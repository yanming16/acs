CREATE TABLE `product`
(
    `prod_id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '该产品线ID',
    `access_token` varchar(100) NOT NULL DEFAULT '' COMMENT 'access token',
    `en_name`      varchar(45)  NOT NULL DEFAULT '' COMMENT '该产品线的英文名称n',
    `cn_name`      varchar(45)  NOT NULL DEFAULT '' COMMENT '该产品线的中文名称',
    `desc`         varchar(200) NOT NULL DEFAULT '' COMMENT '该产品线的中文描述',
    `create_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`prod_id`),
    UNIQUE KEY `uniq_en_name` (`en_name`) USING BTREE,
    UNIQUE KEY `uniq_access_token` (`access_token`) USING BTREE,
    KEY            `idx_cn_name` (`cn_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品线'