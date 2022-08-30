CREATE TABLE `user`
(
    `user_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '该用户的IDn',
    `prod_id`     bigint(20) NOT NULL DEFAULT '-1' COMMENT '可访问产品线ID',
    `login_type`  tinyint(4) NOT NULL DEFAULT '1' COMMENT '该用户登录类型',
    `login_id`    bigint(20) NOT NULL DEFAULT '-1' COMMENT '该用户在登录系统里面的ID',
    `login_name`  varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户在登录系统里面的登录名',
    `real_name`   varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户的名称',
    `email`       varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户的电子邮箱，同种登录系统不能重复',
    `gender`      tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户性别，0女，1男',
    `cellphone`   varchar(20)  NOT NULL DEFAULT '' COMMENT '该用户的手机',
    `id_card`     varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户的身份证号',
    `user_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否生效',
    `desc`        varchar(200) NOT NULL DEFAULT '' COMMENT '该用户的额外描述',
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `uniq_login_id_login_type_prod_id` (`login_id`,`login_type`,`prod_id`),
    KEY           `idx_login_name` (`login_name`),
    KEY           `idx_real_name` (`real_name`),
    KEY           `idx_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=519842 DEFAULT CHARSET=utf8 COMMENT='用户表'