CREATE TABLE `role`
(
    `role_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '该角色的ID',
    `en_name`     varchar(254) NOT NULL COMMENT '该角色的英文名称',
    `cn_name`     varchar(254) NOT NULL COMMENT '该角色的中文名称',
    `prod_id`     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该角色所属的产品线ID',
    `desc`        varchar(200) NOT NULL DEFAULT '' COMMENT '该角色的描述',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`role_id`),
    UNIQUE KEY `uniq_en_name_prod_id` (`en_name`,`prod_id`) USING BTREE,
    KEY           `idx_cn_name` (`cn_name`) USING BTREE,
    KEY           `idx_prod_id` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='角色表'