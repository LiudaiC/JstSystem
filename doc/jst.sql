CREATE TABLE jst_account
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '账户id' AUTO_INCREMENT,
    emp_id BIGINT(20) COMMENT '员工id',
    login_name VARCHAR(30) NOT NULL COMMENT '登录账号',
    password VARCHAR(20) NOT NULL COMMENT '登录密码',
    admin_right INT(11) COMMENT '账号权限',
    last_login_time DATETIME COMMENT '上次登录时间'
);
CREATE UNIQUE INDEX emp_id ON jst_account (emp_id);
CREATE TABLE jst_employee
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '员工id' AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL COMMENT '姓名',
    gender TINYINT(4) COMMENT '性别：0男，1女',
    phone VARCHAR(11) COMMENT '联系电话',
    age INT(11) COMMENT '年龄',
    id_num CHAR(18) COMMENT '身份证号',
    address VARCHAR(60) COMMENT '联系地址',
    join_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    dismission_time DATETIME COMMENT '离职时间'
);
CREATE TABLE jst_member
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '会员id' AUTO_INCREMENT,
    phone VARCHAR(11) NOT NULL COMMENT '会员电话',
    name VARCHAR(30) NOT NULL COMMENT '会员姓名',
    password VARCHAR(100) DEFAULT '123456',
    register_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    card_no VARCHAR(11) NOT NULL COMMENT '会员卡号',
    status INT(11) DEFAULT '0' COMMENT '会员卡状态',
    charge_amount DECIMAL(12,2) NOT NULL COMMENT '充值金额',
    expense_amount DECIMAL(12,2) NOT NULL COMMENT '消费金额',
    canceled_time DATETIME COMMENT '注销时间',
    emp_id BIGINT(20) NOT NULL COMMENT '操作员工id',
    balance_amount DECIMAL(12,2) NOT NULL COMMENT '账户余额'
);
CREATE UNIQUE INDEX card_no ON jst_member (card_no);
CREATE TABLE jst_order
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '订单id' AUTO_INCREMENT,
    product_id BIGINT(20) NOT NULL COMMENT '产品id',
    original_price DECIMAL(12,2) NOT NULL COMMENT '原价',
    discount_price DECIMAL(12,2) NOT NULL COMMENT '优惠价',
    real_price DECIMAL(12,2) NOT NULL COMMENT '实收价',
    add_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '订单更新时间',
    remark TEXT COMMENT '订单备注',
    vip_price DECIMAL(12,2) DEFAULT '0.00' NOT NULL COMMENT '会员价',
    employee_id BIGINT(20) NOT NULL COMMENT '操作员工id',
    member_id BIGINT(20) DEFAULT '0' COMMENT '会员id'
);
CREATE TABLE jst_product
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    op_id BIGINT(20) NOT NULL COMMENT '操作人员id',
    product_name VARCHAR(30) NOT NULL COMMENT '产品名称',
    original_price DECIMAL(12,2) NOT NULL COMMENT '原价',
    vip_price DECIMAL(12,2) NOT NULL COMMENT '会员价',
    discount_price DECIMAL(12,2) NOT NULL COMMENT '优惠价',
    add_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);