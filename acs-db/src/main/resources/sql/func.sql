CREATE TABLE `func`
(
    `func_id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '该功能的ID',
    `en_name`        varchar(254)  NOT NULL COMMENT '该功能的英文名称',
    `cn_name`        varchar(254)  NOT NULL COMMENT '中文名称',
    `parent_func_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '父功能的id',
    `prod_id`        bigint(20) NOT NULL DEFAULT '-1' COMMENT '该功能所属的产品线n',
    `res_content`    varchar(4095) NOT NULL DEFAULT '' COMMENT '该功能的资源内容',
    `desc`           varchar(200)  NOT NULL DEFAULT '' COMMENT '该功能的描述',
    `parent_path`    varchar(255)  NOT NULL DEFAULT '' COMMENT '该节点的父路径',
    `create_time`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`func_id`),
    UNIQUE KEY `uniq_en_name_prod_id` (`en_name`,`prod_id`) USING BTREE,
    KEY              `idx_cn_name` (`cn_name`) USING BTREE,
    KEY              `idx_parent_func_id` (`parent_func_id`),
    KEY              `idx_prod_id` (`prod_id`),
    KEY              `idx_parent_path` (`parent_path`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8 COMMENT='功能'