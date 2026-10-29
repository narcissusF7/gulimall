# 谷粒商城微服务骨架 Demo（尚硅谷风格）

基于 **Spring Boot 2.7.18 + Spring Cloud 2021.0.8 + Spring Cloud Alibaba 2021.0.5.0 + MyBatis-Plus** 的谷粒商城微服务骨架，Java 8 可直接运行。

## 模块结构

```
gulimall
├── gulimall-common     公共模块（统一返回 R / 异常 / 分页 / MyBatis-Plus 配置）
├── gulimall-product    商品服务   端口 10000   （含品牌完整 CRUD 范式）
├── gulimall-coupon     优惠券服务 端口 7000
├── gulimall-member     会员服务   端口 8000
├── gulimall-order      订单服务   端口 9000   （含 OpenFeign 远程调用示例）
├── gulimall-ware       仓储服务   端口 11000
├── gulimall-gateway    API 网关   端口 88     （/api/{服务}/** 统一路由）
├── docker-compose.yml  一键启动 Nacos + MySQL
└── sql/init.sql        初始化 5 个数据库 + 品牌表示例数据
```

## 快速运行

### 1. 启动依赖（Nacos 注册中心 + MySQL）
```bash
cd gulimall
docker-compose up -d
```
浏览器访问 http://localhost:8848/nacos （默认账号/密码 nacos/nacos）确认服务注册页可用。

> 不使用 Docker 时：自行安装 Nacos 2.x（standalone）与 MySQL 8.x，并手动执行 `sql/init.sql`，
> 再按 `application.yml` 中的 `server-addr` / 数据源信息调整连接。

### 2. 编译公共模块（其余模块依赖它）
```bash
mvn -q -pl gulimall-common -am install
```

### 3. 启动各微服务（每个开一个终端）
```bash
mvn -pl gulimall-gateway -am spring-boot:run
mvn -pl gulimall-product -am spring-boot:run
mvn -pl gulimall-coupon  -am spring-boot:run
mvn -pl gulimall-member  -am spring-boot:run
mvn -pl gulimall-order   -am spring-boot:run
mvn -pl gulimall-ware    -am spring-boot:run
```

### 4. 验证接口
```bash
# 网关统一入口
curl http://localhost:88/api/product/brand/hello
curl http://localhost:88/api/coupon/demo/hello
curl http://localhost:88/api/order/demo/with/product?brandId=1   # 跨服务 Feign 调用

# 商品品牌 CRUD（需 MySQL 已初始化 pms_brand 表）
curl http://localhost:88/api/product/brand/list
curl -X POST http://localhost:88/api/product/brand -H 'Content-Type: application/json' -d '{"name":"测试品牌","showStatus":1,"firstLetter":"T","sort":3}'
```

## 约定与扩展指引

- **统一返回**：所有接口返回 `R`（code=0 成功，非 0 异常；data 承载主体数据）。
- **统一异常**：`com.atguigu.common.exception` 下 `RRException` + 全局处理器，业务码见 `BizCodeEnum`。
- **新增实体**：参照 `gulimall-product` 的 `entity → dao → service → controller` 四层范式。
- **远程调用**：在调用方新建 `@FeignClient("服务名")` 接口，并在启动类开启 `@EnableFeignClients`。
- **配置中心**：当前把配置写在各 `application.yml`。生产可引入 `spring-cloud-starter-alibaba-nacos-config` + `bootstrap.yml` 接管配置。

## 已知限制（骨架范畴）

- 仅实现骨架与示例接口，未含真实业务（下单链路、库存扣减、鉴权、分布式事务等）。
- 网关未做限流/鉴权；服务间调用未做熔断降级（可加 sentinel）。
- 数据库密码写在 yml，生产请改用环境变量 / 配置中心。
