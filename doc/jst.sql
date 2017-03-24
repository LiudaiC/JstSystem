DROP TABLE IF EXISTS jst_member;
CREATE TABLE jst_member(
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '会员id',
  card_no VARCHAR(11) NOT NULL UNIQUE COMMENT '会员卡号',
  status INT DEFAULT 0 COMMENT '会员卡状态',
  charge_amount DECIMAL(6,2) NOT NULL COMMENT '充值金额',
  expense_amount DECIMAL(6, 2) NOT NULL COMMENT '消费金额',
  phone VARCHAR(11) NOT NULL  COMMENT '会员电话',
  name VARCHAR(30) NOT NULL COMMENT '会员姓名',
  password VARCHAR(100) DEFAULT '123456',
  register_time DATETIME DEFAULT now() COMMENT '注册时间',
  update_time DATETIME DEFAULT now() COMMENT '修改时间',
  canceled_time DATETIME COMMENT '注销时间'
) ENGINE=Innodb CHARSET=UTF8 COMMENT '会员管理表';

CREATE TABLE JST_ORDER (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '订单id',
  product_id BIGINT NOT NULL COMMENT '产品id',
  op_id BIGINT NOT NULL COMMENT '操作人员id',
  mem_id BIGINT COMMENT '会员id',
  original_price DECIMAL(6,2) COMMENT '原价',
  discount_price DECIMAL(6,2) COMMENT '优惠价',
  real_price DECIMAL(6,2) NOT NULL COMMENT '实际价格',
  add_time DATETIME DEFAULT now() COMMENT '新增时间',
  update_time DATETIME DEFAULT now() COMMENT '订单更新时间',
  remark text COMMENT '订单备注'
) ENGINE = Innodb CHARSET =UTF8 COMMENT '订单管理表';

CREATE TABLE JST_PRODUCT (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '',
  op_id BIGINT NOT NULL COMMENT '操作人员id',
  product_name VARCHAR(30) NOT NULL COMMENT '产品名称',
  original_price DECIMAL(6, 2) COMMENT '原价',
  vip_price DECIMAL(6,2) COMMENT '会员价',
  discount_price DECIMAL(6,2) COMMENT '优惠价',
  add_time DATETIME DEFAULT now() COMMENT '新增时间',
  update_time DATETIME DEFAULT now() COMMENT '更新时间'
) ENGINE = Innodb CHARSET = UTF8 COMMENT '产品管理表';

CREATE TABLE JST_EMPLOYEE(
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '员工id',
  name VARCHAR(30) NOT NULL COMMENT '姓名',
  gender TINYINT COMMENT '性别：0男，1女',
  phone VARCHAR(11) COMMENT '联系电话',
  age INT COMMENT '年龄',
  id_num CHAR(18) COMMENT '身份证号',
  address VARCHAR(60) COMMENT '联系地址',
  join_time DATETIME DEFAULT now() COMMENT '入职时间',
  update_time DATETIME DEFAULT now() COMMENT '修改时间',
  dismission_time DATETIME COMMENT '离职时间'
) ENGINE = Innodb CHARSET = UTF8 COMMENT '员工管理表';

DROP TABLE if EXISTS JST_ACCOUNT;
CREATE TABLE JST_ACCOUNT(
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '账户id',
  emp_id BIGINT UNIQUE COMMENT '员工id',
  login_name VARCHAR(30) UNIQUE COMMENT '登录账号',
  password VARCHAR(20) NOT NULL COMMENT '登录密码',
  admin_right INT COMMENT '账号权限',
  last_login_time DATETIME COMMENT '上次登录时间'
) ENGINE = Innodb CHARSET = UTF8 COMMENT '账号管理表';








INSERT INTO JST_ACCOUNT(login_name,password,admin_right,last_login_time) VALUES ('admin', '123456', 3, now());
















