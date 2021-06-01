DROP TABLE IF EXISTS t_sys_user;
/**
  用户表
 */
CREATE TABLE t_sys_user  (
  id         BIGSERIAL PRIMARY KEY,
  username   VARCHAR(255) NOT NULL UNIQUE ,
  email      VARCHAR(255) NOT NULL UNIQUE ,
  password   VARCHAR(255) NOT NULL ,
  name       VARCHAR(32) NULL DEFAULT NULL ,
  phone      VARCHAR(20) NULL DEFAULT NULL ,
  telephone  VARCHAR(16) NULL DEFAULT NULL ,
  address    VARCHAR(64) NULL DEFAULT NULL ,
  enabled    BOOLEAN NOT NULL DEFAULT true,
  userFace   VARCHAR(255) NULL DEFAULT NULL ,
  remark     VARCHAR(255) NULL DEFAULT NULL ,
  createdAt  timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP),
  updatedAt  timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
comment on table t_sys_user is '角色表';
comment on column t_sys_user.id is 'ID';
comment on column t_sys_user.name is '用户名';
comment on column t_sys_user.username is '登录名';

-- SQLINES DEMO *** -----------
INSERT INTO t_sys_user(username,email,password) VALUES ('admin' , 'admin@sleeep.io','$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe');
INSERT INTO t_sys_user(username,email,password) VALUES ('user1', 'xx@cn.cn', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe');
INSERT INTO t_sys_user(username,email,password) VALUES ('user2', 'xx2@cn.cn', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe');
INSERT INTO t_sys_user(username,email,password) VALUES ('user3', 'xx3@cn.cn', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe' );
INSERT INTO t_sys_user(username,email,password) VALUES ('user4', 'xx4@cn.cn', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe');

/**
  角色表
 */
DROP TABLE IF EXISTS t_sys_role;
CREATE TABLE t_sys_role(
  id     BIGSERIAL primary key,
  name   VARCHAR(50) null default null,
  nameZh VARCHAR(50) null default null
);
comment on table t_sys_role is '角色表';
comment on column t_sys_role.id is 'ID';
comment on column t_sys_role.name is '角色名称';
comment on column t_sys_role.nameZh is '角色中文名';

INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_manager', '部门经理');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_personnel', '人事专员');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_recruiter', '招聘主管');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_train', '培训主管');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_performance', '薪酬绩效主管');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_admin', '系统管理员');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_test', '测试角色');

/**
  用户角色表
 */
DROP TABLE IF EXISTS t_sys_user_role;
CREATE TABLE t_sys_user_role(
  id       BIGSERIAL primary key,
  user_id  BIGINT NULL,
  role_id  BIGINT NULL
);
comment on table t_sys_user_role is '用户权限表';
comment on column t_sys_user_role.id is 'ID';
comment on column t_sys_user_role.user_id is '用户id';
comment on column t_sys_user_role.role_id is '权限id';

INSERT INTO t_sys_user_role(user_id, role_id) VALUES (1, 6);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (5, 4);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (5, 3);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (5, 2);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (4, 3);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (4, 2);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (4, 4);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (4, 5);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (3, 3);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (3, 4);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (2, 3);
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (2, 4);

/**
  菜单表
 */
DROP TABLE IF EXISTS t_sys_menu;
CREATE TABLE t_sys_menu(
    id          BIGSERIAL primary key,
    url         varchar(64) NULL DEFAULT NULL,
    path        varchar(64) NULL DEFAULT NULL,
    component   varchar(64) NULL DEFAULT NULL,
    name        varchar(64) NULL DEFAULT NULL,
    iconCls     varchar(64) NULL DEFAULT NULL,
    keepAlive   BIGINT default 0,
    requireAuth BIGINT default 0,
    parentId    BIGINT null default null,
    enabled     BIGINT default 0
);
comment on table t_sys_menu is '菜单表';
comment on column t_sys_menu.url is 'url';
comment on column t_sys_menu.path is 'path';
comment on column t_sys_menu.component is '组件';
comment on column t_sys_menu.name is '菜单名';
comment on column t_sys_menu.iconCls is '菜单图标';
comment on column t_sys_menu.keepAlive is '是否保持激活';
comment on column t_sys_menu.requireAuth is '是否要求权限';
comment on column t_sys_menu.parentId is '父id';
comment on column t_sys_menu.enabled is '是否启用';

INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/', NULL, NULL, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', NULL, 1, 1, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', NULL, 1, 1, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/', '/home', 'Home', '薪资管理', 'fa fa-money', NULL, 1, 1, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', NULL, 1, 1, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/', '/home', 'Home', '系统管理', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', NULL, NULL, 1, 2, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', NULL, NULL, 1, 2, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/personnel/emp/**', '/per/emp', 'PerEmp', '员工资料', NULL, NULL, 1, 3, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', NULL, NULL, 1, 3, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/personnel/train/**', '/per/train', 'PerTrain', '员工培训', NULL, NULL, 1, 3, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', NULL, NULL, 1, 3, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/personnel/remove/**', '/per/mv', 'PerMv', '员工调动', NULL, NULL, 1, 3, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', NULL, NULL, 1, 4, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', NULL, NULL, 1, 4, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/salary/table/**', '/sal/table', 'SalTable', '工资表管理', NULL, NULL, 1, 4, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/salary/month/**', '/sal/month', 'SalMonth', '月末处理', NULL, NULL, 1, 4, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', NULL, NULL, 1, 4, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', NULL, NULL, 1, 5, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', NULL, NULL, 1, 5, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', NULL, NULL, 1, 6, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', NULL, NULL, 1, 6, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/system/log/**', '/sys/log', 'SysLog', '操作日志管理', NULL, NULL, 1, 6, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/system/admin/**', '/sys/admin', 'SysAdmin', '操作员管理', NULL, NULL, 1, 6, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/system/data/**', '/sys/data', 'SysData', '备份恢复数据库', NULL, NULL, 1, 6, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled) VALUES ('/system/init/**', '/sys/init', 'SysInit', '初始化数据库', NULL, NULL, 1, 6, 1);

/**
  菜单角色表
 */
DROP TABLE IF EXISTS t_sys_menu_role;
CREATE TABLE t_sys_menu_role(
    id       BIGSERIAL primary key,
    menu_id  BIGINT NULL,
    role_id  BIGINT NULL
);
comment on table t_sys_menu_role is '菜单权限表';
comment on column t_sys_menu_role.id is 'ID';
comment on column t_sys_menu_role.menu_id is '菜单id';
comment on column t_sys_menu_role.role_id is '权限id';

INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (7, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (9, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (10, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (11, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (12, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (13, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (14, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (15, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (16, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (17, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (18, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (19, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (20, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (21, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (22, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (23, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (25, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (26, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (27, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (28, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (24, 6);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (7, 3);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (7, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (8, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (9, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (10, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (12, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (13, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (7, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (8, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (9, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (10, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (11, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (12, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (13, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (14, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (15, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (16, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (17, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (18, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (19, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (20, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (21, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (22, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (23, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (24, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (25, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (26, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (27, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (28, 1);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (11, 4);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (8, 4);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (7, 4);

/**
  职位表
 */
DROP TABLE IF EXISTS t_sys_position;
CREATE TABLE t_sys_position  (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(32) NULL DEFAULT NULL ,
    enabled    BOOLEAN NOT NULL DEFAULT true,
    createdAt  timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
INSERT INTO t_sys_position(name) VALUES ('技术总监');
INSERT INTO t_sys_position(name) VALUES ('运营总监');
INSERT INTO t_sys_position(name) VALUES ('市场总监');
INSERT INTO t_sys_position(name) VALUES ('研发工程师');
INSERT INTO t_sys_position(name) VALUES ('运维工程师');



/**
  职称表
 */
DROP TABLE IF EXISTS t_sys_joblevel;
CREATE TABLE t_sys_joblevel  (
  id         BIGSERIAL PRIMARY KEY,
  name       VARCHAR(32) NULL DEFAULT NULL ,
  titleLevel VARCHAR(32) NULL DEFAULT NULL ,
  enabled    BOOLEAN NOT NULL DEFAULT true,
  createdAt  timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);