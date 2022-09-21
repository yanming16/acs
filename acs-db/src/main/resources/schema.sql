DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    prod_id      bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '该产品线ID',
    access_token varchar(100) NOT NULL DEFAULT '' COMMENT 'access token',
    en_name      varchar(45)  NOT NULL DEFAULT '' COMMENT '该产品线的英文名称n',
    cn_name      varchar(45)  NOT NULL DEFAULT '' COMMENT '该产品线的中文名称',
    desc         varchar(200) NOT NULL DEFAULT '' COMMENT '该产品线的中文描述',
    create_time  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);
create unique index uniq_product_en_name on product (en_name);
create unique index uniq_product_access_token on product (access_token);
create index idx_product_cn_name on product (cn_name);

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    user_id     bigint(20)   NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '该用户的IDn',
    prod_id     bigint(20)   NOT NULL DEFAULT '-1' COMMENT '可访问产品线ID',
    login_type  tinyint(4)   NOT NULL DEFAULT '1' COMMENT '该用户登录类型',
    login_id    bigint(20)   NOT NULL DEFAULT '-1' COMMENT '该用户在登录系统里面的ID',
    login_name  varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户在登录系统里面的登录名',
    real_name   varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户的名称',
    email       varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户的电子邮箱，同种登录系统不能重复',
    gender      tinyint(1)   NOT NULL DEFAULT '0' COMMENT '用户性别，0女，1男',
    cellphone   varchar(20)  NOT NULL DEFAULT '' COMMENT '该用户的手机',
    id_card     varchar(45)  NOT NULL DEFAULT '' COMMENT '该用户的身份证号',
    user_status tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否生效',
    desc        varchar(200) NOT NULL DEFAULT '' COMMENT '该用户的额外描述',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);
create unique index uniq_user_login_id_login_type_prod_id on user (login_id, login_type, prod_id);
create index idx_user_login_name on user (login_name);
create index idx_user_real_name on user (real_name);
create index idx_user_email on user (email);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    id          bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
    user_id     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该用户的ID',
    role_id     bigint(20) NOT NULL DEFAULT '-1' COMMENT '绑定的角色',
    create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);
create unique index uniq_user_role_user_role on user_role (user_id, role_id);
create index idx_user_role_role_id on user_role (role_id);

DROP TABLE IF EXISTS role;
CREATE TABLE role
(
    role_id     bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '该角色的ID',
    en_name     varchar(254) NOT NULL COMMENT '该角色的英文名称',
    cn_name     varchar(254) NOT NULL COMMENT '该角色的中文名称',
    prod_id     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该角色所属的产品线ID',
    desc        varchar(200) NOT NULL DEFAULT '' COMMENT '该角色的描述',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);
create unique index uniq_role_en_name_prod_id on role (en_name, role_id);
create index idx_role_cn_name on role (cn_name);
create index idx_role_prod_id on role (prod_id);

DROP TABLE IF EXISTS role_func;
CREATE TABLE role_func
(
    id       bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '自增id',
    role_id     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该授权的角色ID',
    func_id     bigint(20) NOT NULL DEFAULT '-1' COMMENT '该授权绑定的功能',
    create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);
create unique index uniq_role_func_role_id_func_id on role_func (role_id, func_id);

DROP TABLE IF EXISTS func;
CREATE TABLE func
(
    func_id        bigint(20) NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT '该功能的ID',
    en_name        varchar(254)  NOT NULL COMMENT '该功能的英文名称',
    cn_name        varchar(254)  NOT NULL COMMENT '中文名称',
    parent_func_id bigint(20) NOT NULL DEFAULT '-1' COMMENT '父功能的id',
    prod_id        bigint(20) NOT NULL DEFAULT '-1' COMMENT '该功能所属的产品线n',
    res_content    varchar(4095) NOT NULL DEFAULT '' COMMENT '该功能的资源内容',
    desc           varchar(200)  NOT NULL DEFAULT '' COMMENT '该功能的描述',
    parent_path    varchar(255)  NOT NULL DEFAULT '' COMMENT '该节点的父路径',
    create_time    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);
create unique index uniq_func_en_name_prod_id on func (en_name, prod_id);
create index idx_func_cn_name on func (cn_name);
create index idx_func_parent_func_id on func (parent_func_id);
create index idx_func_prod_id on func (prod_id);
create index idx_func_parent_path on func (parent_path);