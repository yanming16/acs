CREATE TABLE `user_role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `user_id`     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该用户的ID',
    `role_id`     bigint(20) NOT NULL DEFAULT '-1' COMMENT '绑定的角色',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_user_role` (`user_id`,`role_id`) USING BTREE,
    KEY           `idx_role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=621404 DEFAULT CHARSET=utf8 COMMENT='用户角色绑定'