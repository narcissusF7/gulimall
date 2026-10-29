-- 谷粒商城骨架初始化脚本：创建各微服务数据库 + 商品服务品牌表示例表
-- 由 docker-compose 挂载到 MySQL 自动执行

CREATE DATABASE IF NOT EXISTS gulimall_pms DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS gulimall_sms DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS gulimall_ums DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS gulimall_oms DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS gulimall_wms DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE gulimall_pms;

DROP TABLE IF EXISTS pms_brand;
CREATE TABLE pms_brand (
    brand_id     BIGINT NOT NULL AUTO_INCREMENT COMMENT '品牌id',
    name         VARCHAR(255) DEFAULT NULL COMMENT '品牌名',
    logo         VARCHAR(255) DEFAULT NULL COMMENT '品牌logo地址',
    descript     LONGTEXT COMMENT '介绍',
    show_status  TINYINT(1) DEFAULT NULL COMMENT '显示状态[0-不显示；1-显示]',
    first_letter CHAR(1) DEFAULT NULL COMMENT '检索首字母',
    sort         INT(11) DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (brand_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='品牌';

INSERT INTO pms_brand (name, logo, descript, show_status, first_letter, sort)
VALUES ('华为', 'huawei.png', '华为技术有限公司', 1, 'H', 1),
       ('小米', 'xiaomi.png', '小米科技有限责任公司', 1, 'X', 2);
