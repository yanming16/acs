CREATE TABLE `role_func`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `role_id`     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该授权的角色ID',
    `func_id`     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该授权绑定的功能',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_role_id_func_id` (`role_id`, `func_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1202 DEFAULT CHARSET=utf8 COMMENT='角色授权'