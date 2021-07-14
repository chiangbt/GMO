/**
  1、职位表
 */
DROP TABLE IF EXISTS t_sys_position;
CREATE TABLE t_sys_position  (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(32) NULL DEFAULT NULL ,
    enabled    BOOLEAN NOT NULL DEFAULT TRUE,
    createdAt  timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
COMMENT ON TABLE  t_sys_position IS '职位表';
COMMENT ON COLUMN t_sys_position.id IS 'ID';
COMMENT ON COLUMN t_sys_position.name IS '职位名称';
COMMENT ON COLUMN t_sys_position.enabled IS '是否有效';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_position(name) VALUES ('技术总监');
INSERT INTO t_sys_position(name) VALUES ('运营总监');
INSERT INTO t_sys_position(name) VALUES ('市场总监');
INSERT INTO t_sys_position(name) VALUES ('研发工程师');
INSERT INTO t_sys_position(name) VALUES ('运维工程师');


/**
  2、民族表
 */
DROP TABLE IF EXISTS t_sys_nation;
CREATE TABLE t_sys_nation  (
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(32) NULL DEFAULT NULL
);
COMMENT ON TABLE  t_sys_nation IS '民族表';
COMMENT ON COLUMN t_sys_nation.id IS 'ID';
COMMENT ON COLUMN t_sys_nation.name IS '民族';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_nation(name) VALUES ('汉族');
INSERT INTO t_sys_nation(name) VALUES ('蒙古族');
INSERT INTO t_sys_nation(name) VALUES ('回族');
INSERT INTO t_sys_nation(name) VALUES ('藏族');
INSERT INTO t_sys_nation(name) VALUES ('维吾尔族');
INSERT INTO t_sys_nation(name) VALUES ('苗族');
INSERT INTO t_sys_nation(name) VALUES ('彝族');
INSERT INTO t_sys_nation(name) VALUES ('壮族');
INSERT INTO t_sys_nation(name) VALUES ('布依族');
INSERT INTO t_sys_nation(name) VALUES ('朝鲜族');
INSERT INTO t_sys_nation(name) VALUES ('满族');
INSERT INTO t_sys_nation(name) VALUES ('侗族');
INSERT INTO t_sys_nation(name) VALUES ('瑶族');
INSERT INTO t_sys_nation(name) VALUES ('白族');
INSERT INTO t_sys_nation(name) VALUES ('土家族');
INSERT INTO t_sys_nation(name) VALUES ('哈尼族');
INSERT INTO t_sys_nation(name) VALUES ('哈萨克族');
INSERT INTO t_sys_nation(name) VALUES ('傣族');
INSERT INTO t_sys_nation(name) VALUES ('黎族');
INSERT INTO t_sys_nation(name) VALUES ('傈僳族');
INSERT INTO t_sys_nation(name) VALUES ('佤族');
INSERT INTO t_sys_nation(name) VALUES ('畲族');
INSERT INTO t_sys_nation(name) VALUES ('高山族');
INSERT INTO t_sys_nation(name) VALUES ('拉祜族');
INSERT INTO t_sys_nation(name) VALUES ('水族');
INSERT INTO t_sys_nation(name) VALUES ('东乡族');
INSERT INTO t_sys_nation(name) VALUES ('纳西族');
INSERT INTO t_sys_nation(name) VALUES ('景颇族');
INSERT INTO t_sys_nation(name) VALUES ('柯尔克孜族');
INSERT INTO t_sys_nation(name) VALUES ('土族');
INSERT INTO t_sys_nation(name) VALUES ('达斡尔族');
INSERT INTO t_sys_nation(name) VALUES ('仫佬族');
INSERT INTO t_sys_nation(name) VALUES ('羌族');
INSERT INTO t_sys_nation(name) VALUES ('布朗族');
INSERT INTO t_sys_nation(name) VALUES ('撒拉族');
INSERT INTO t_sys_nation(name) VALUES ('毛难族');
INSERT INTO t_sys_nation(name) VALUES ('仡佬族');
INSERT INTO t_sys_nation(name) VALUES ('锡伯族');
INSERT INTO t_sys_nation(name) VALUES ('阿昌族');
INSERT INTO t_sys_nation(name) VALUES ('普米族');
INSERT INTO t_sys_nation(name) VALUES ('塔吉克族');
INSERT INTO t_sys_nation(name) VALUES ('怒族');
INSERT INTO t_sys_nation(name) VALUES ('乌孜别克族');
INSERT INTO t_sys_nation(name) VALUES ('俄罗斯族');
INSERT INTO t_sys_nation(name) VALUES ('鄂温克族');
INSERT INTO t_sys_nation(name) VALUES ('崩龙族');
INSERT INTO t_sys_nation(name) VALUES ('保安族');
INSERT INTO t_sys_nation(name) VALUES ('裕固族');
INSERT INTO t_sys_nation(name) VALUES ('京族');
INSERT INTO t_sys_nation(name) VALUES ('塔塔尔族');
INSERT INTO t_sys_nation(name) VALUES ('独龙族');
INSERT INTO t_sys_nation(name) VALUES ('鄂伦春族');
INSERT INTO t_sys_nation(name) VALUES ('赫哲族');
INSERT INTO t_sys_nation(name) VALUES ('门巴族');
INSERT INTO t_sys_nation(name) VALUES ('珞巴族');
INSERT INTO t_sys_nation(name) VALUES ('基诺族');


/**
  3、政治面貌表
 */
DROP TABLE IF EXISTS t_sys_politics_status;
CREATE TABLE t_sys_politics_status  (
     id         BIGSERIAL PRIMARY KEY,
     name       VARCHAR(32) NULL DEFAULT NULL
);
COMMENT ON TABLE  t_sys_politics_status IS '政治面貌表';
COMMENT ON COLUMN t_sys_politics_status.id IS 'ID';
COMMENT ON COLUMN t_sys_politics_status.name IS '政治面貌';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_politics_status(name) VALUES ('中共党员');
INSERT INTO t_sys_politics_status(name) VALUES ('中共预备党员');
INSERT INTO t_sys_politics_status(name) VALUES ('共青团员');
INSERT INTO t_sys_politics_status(name) VALUES ('民革党员');
INSERT INTO t_sys_politics_status(name) VALUES ('民盟盟员');
INSERT INTO t_sys_politics_status(name) VALUES ('民建会员');
INSERT INTO t_sys_politics_status(name) VALUES ('民进会员');
INSERT INTO t_sys_politics_status(name) VALUES ('农工党党员');
INSERT INTO t_sys_politics_status(name) VALUES ('致公党党员');
INSERT INTO t_sys_politics_status(name) VALUES ('九三学社社员');
INSERT INTO t_sys_politics_status(name) VALUES ('台盟盟员');
INSERT INTO t_sys_politics_status(name) VALUES ('无党派民主人士');
INSERT INTO t_sys_politics_status(name) VALUES ('普通公民');

/**
  4、职称表
 */
DROP TABLE IF EXISTS t_sys_joblevel;
CREATE TABLE t_sys_joblevel  (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(32) NULL DEFAULT NULL ,
    titleLevel VARCHAR(32) NULL DEFAULT NULL ,
    enabled    BOOLEAN NOT NULL DEFAULT true,
    createdAt  timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
COMMENT ON TABLE  t_sys_joblevel IS '职称表';
COMMENT ON COLUMN t_sys_joblevel.id IS 'ID';
COMMENT ON COLUMN t_sys_joblevel.name IS '职称名称';
COMMENT ON COLUMN t_sys_joblevel.titleLevel IS '职称等级';
COMMENT ON COLUMN t_sys_joblevel.enabled IS '是否启用';
COMMENT ON COLUMN t_sys_joblevel.createdAt IS '新建时间';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('教授','正高级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('教授级工程师','正高级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('副教授','副高级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('高级工程','副高级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('讲师','中级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('中级工程师','中级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('初级工程师','初级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('助教','初级');
INSERT INTO t_sys_joblevel(name, titleLevel) VALUES ('未定级','未定级');

/**
  5、部门表
 */
DROP TABLE IF EXISTS t_sys_department;
CREATE TABLE t_sys_department  (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(32) NULL DEFAULT NULL ,
    parentid   INTEGER NULL DEFAULT NULL,
    deppath    VARCHAR(255) NULL DEFAULT  NULL,
    enabled    BOOLEAN NOT NULL DEFAULT true,
    isparent   BOOLEAN NOT NULL DEFAULT false
);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('股东会', -1, '.1', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('董事会', 1, '.1.2', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('总经办', 2, '.1.2.3', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('财务部', 3, '.1.2.3.4', true, false);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('市场部', 3, '.1.2.3.5', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('华东市场部', 5, '1.2.3.5.6', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('华南市场部', 5, '1.2.3.5.7', true, false);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('上海市场部', 6, '1.2.3.5.6.8', true, false);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('西北市场部', 5, '.1.2.3.5.9', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('贵阳市场', 9, '.1.2.3.5.9.10', true, true);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('乌当区市场', 10, '.1.2.3.5.9.10.11', true, false);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('技术部', 3, '.1.2.3.12', true, false);
INSERT INTO t_sys_department(name,parentid,deppath,enabled,isparent) VALUES ('运维部', 3, '.1.2.3.13', true, false);

/**
  6、用户表
 */
DROP TABLE IF EXISTS t_sys_user;
CREATE TABLE t_sys_user  (
  id            BIGSERIAL PRIMARY KEY,
  username      VARCHAR(255) NOT NULL UNIQUE,
  email         VARCHAR(255) NOT NULL UNIQUE,
  password      VARCHAR(255) NOT NULL,
  name          VARCHAR(32) NULL DEFAULT NULL,
  phone         VARCHAR(20) NULL DEFAULT NULL,
  nationId      INTEGER NULL DEFAULT 1,
  politicId     INTEGER NULL DEFAULT 1,
  departmentId  INTEGER NULL DEFAULT NULL,
  jobLevelId    INTEGER NULL DEFAULT 1,
  posId         INTEGER NULL DEFAULT 1,
  enabled       BOOLEAN NOT NULL DEFAULT TRUE,
  userFace      VARCHAR(255) NULL DEFAULT NULL,
  remark        VARCHAR(255) NULL DEFAULT NULL,
  createdAt     timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP),
  updatedAt     timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP),
  FOREIGN KEY (jobLevelId) REFERENCES t_sys_joblevel (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  FOREIGN KEY (posId) REFERENCES t_sys_position (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  FOREIGN KEY (nationId) REFERENCES t_sys_nation (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  FOREIGN KEY (politicId) REFERENCES t_sys_politics_status (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
COMMENT ON table  t_sys_user IS '角色表';
COMMENT ON COLUMN t_sys_user.id IS 'ID';
COMMENT ON COLUMN t_sys_user.name IS '用户姓名';
COMMENT ON COLUMN t_sys_user.email IS '电子邮件';
COMMENT ON COLUMN t_sys_user.password IS '密码';
COMMENT ON COLUMN t_sys_user.username IS '登录名';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_user(username,email,password,name,phone,nationid,politicid,joblevelid,posid,departmentId) VALUES ('admin' , 'admin@sleeep.io','$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe', 'admin','13819847814', 1, 1, 1, 1, 3);

/**
  7、角色表
 */
DROP TABLE IF EXISTS t_sys_role;
CREATE TABLE t_sys_role(
  id     BIGSERIAL PRIMARY KEY,
  name   VARCHAR(50) NULL DEFAULT NULL,
  nameZh VARCHAR(50) NULL DEFAULT NULL
);
COMMENT ON TABLE  t_sys_role IS '角色表';
COMMENT ON COLUMN t_sys_role.id IS 'ID';
COMMENT ON COLUMN t_sys_role.name IS '角色名称';
COMMENT ON COLUMN t_sys_role.nameZh IS '角色中文名';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_admin', '超级管理员');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_manager', '行政主管');
INSERT INTO t_sys_role(name, nameZh) VALUES ('ROLE_train', '培训主管');

/**
  8、用户角色表
 */
DROP TABLE IF EXISTS t_sys_user_role;
CREATE TABLE t_sys_user_role(
  id       BIGSERIAL PRIMARY KEY,
  user_id  BIGINT NULL,
  role_id  BIGINT NULL
);
COMMENT ON TABLE  t_sys_user_role IS '用户权限表';
COMMENT ON COLUMN t_sys_user_role.id IS 'ID';
COMMENT ON COLUMN t_sys_user_role.user_id IS '用户id';
COMMENT ON COLUMN t_sys_user_role.role_id IS '权限id';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_user_role(user_id, role_id) VALUES (1, 1);

/**
  9、菜单表
 */
DROP TABLE IF EXISTS t_sys_menu;
CREATE TABLE t_sys_menu(
    id          BIGSERIAL PRIMARY KEY,
    url         varchar(64) NULL DEFAULT NULL,
    path        varchar(64) NULL DEFAULT NULL,
    component   varchar(64) NULL DEFAULT NULL,
    name        varchar(64) NULL DEFAULT NULL,
    iconCls     varchar(64) NULL DEFAULT NULL,
    keepAlive   BIGINT DEFAULT 0,
    requireAuth BIGINT DEFAULT 0,
    parentId    BIGINT NULL DEFAULT NULL,
    enabled     BIGINT DEFAULT 0,
    orders       BIGINT DEFAULT 0
);
COMMENT ON TABLE  t_sys_menu IS '菜单表';
COMMENT ON COLUMN t_sys_menu.url IS 'url';
COMMENT ON COLUMN t_sys_menu.path IS 'path';
COMMENT ON COLUMN t_sys_menu.component IS '组件';
COMMENT ON COLUMN t_sys_menu.name IS '菜单名';
COMMENT ON COLUMN t_sys_menu.iconCls IS '菜单图标';
COMMENT ON COLUMN t_sys_menu.keepAlive IS '是否保持激活';
COMMENT ON COLUMN t_sys_menu.requireAuth IS '是否要求权限';
COMMENT ON COLUMN t_sys_menu.parentId IS '父id';
COMMENT ON COLUMN t_sys_menu.enabled IS '是否启用';
COMMENT ON COLUMN t_sys_menu.orders IS '顺序';
-- SQLINES DEMO *** -----------
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/', NULL, NULL, '首页', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/', '/home', 'Home', '客户资料', 'fa fa-user-circle-o', NULL, 1, 1, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/', '/home', 'Home', '空间数据', 'fa fa-address-card-o', NULL, 1, 1, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/', '/home', 'Home', '内容管理', 'fa fa-globe', NULL, 1, 1, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/', '/home', 'Home', '统计信息', 'fa fa-bar-chart', NULL, 1, 1, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/', '/home', 'Home', '系统管理', 'fa fa-windows', NULL, 1, 1, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/person/customer/**', '/cus/info', 'CusInfo', '客户信息', NULL, NULL, 1, 2, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/person/mail/**', '/cus/mail', 'CusMail', '客户邮件', NULL, NULL, 1, 2, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/person/employee/**', '/cus/employee', 'CusEmployee', '雇员信息', NULL, NULL, 1, 2, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/spatial/emp/**', '/sdb/poi', 'SDBPoi', 'POI数据', NULL, NULL, 1, 3, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/spatial/ec/**', '/sdb/raod', 'SDBRoad', '道路数据', NULL, NULL, 1, 3, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/spatial/salary/**', '/sdb/polygon', 'SDBPolygon', '地块数据', NULL, NULL, 1, 3, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/spatial/train/**', '/sdb/2d', 'SDB2D', 'ArcGIS二维', NULL, NULL, 1, 3, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/spatial/remove/**', '/sdb/3d', 'SDB3d', 'ArcGIS三维', NULL, NULL, 1, 3, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', NULL, NULL, 1, 4, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', NULL, NULL, 1, 4, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/salary/table/**', '/sal/table', 'SalTable', '工资表管理', NULL, NULL, 1, 4, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/salary/month/**', '/sal/month', 'SalMonth', '月末处理', NULL, NULL, 1, 4, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', NULL, NULL, 1, 4, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', NULL, NULL, 1, 5, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', NULL, NULL, 1, 5, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', NULL, NULL, 1, 5, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', NULL, NULL, 1, 5, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', NULL, NULL, 1, 6, 1, 1);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', NULL, NULL, 1, 6, 1, 2);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/system/admin/**', '/sys/admin', 'SysAdmin', '用户管理', NULL, NULL, 1, 6, 1, 0);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/system/perm/**', '/sys/perm', 'SysPerm', '权限管理', NULL, NULL, 1, 6, 1, 3);
INSERT INTO t_sys_menu(url,path,component,name,iconCls,keepAlive,requireAuth,parentId,enabled,orders) VALUES ('/system/menu/**', '/sys/menu', 'SysMenu', '菜单管理', NULL, NULL, 1, 6, 1, 4);


/**
  10、菜单角色表
 */
DROP TABLE IF EXISTS t_sys_menu_role;
CREATE TABLE t_sys_menu_role(
    id       BIGSERIAL PRIMARY KEY,
    menu_id  BIGINT NULL,
    role_id  BIGINT NULL
);
COMMENT ON TABLE  t_sys_menu_role IS '菜单权限表';
COMMENT ON COLUMN t_sys_menu_role.id IS 'ID';
COMMENT ON COLUMN t_sys_menu_role.menu_id IS '菜单id';
COMMENT ON COLUMN t_sys_menu_role.role_id IS '权限id';
-- SQLINES DEMO *** -----------
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
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (7, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (8, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (9, 2);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (10, 3);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (11, 3);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (12, 3);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (13, 3);
INSERT INTO t_sys_menu_role(menu_id, role_id) VALUES (14, 3);


/**
  添加department对象需要自行多条SQL语句
  在这里我们采用了存储过程的方式
  新建了一个function为adddepartment
 */
CREATE OR REPLACE FUNCTION addDepartment(in depName varchar(32),in parentId int,in enabled boolean)
    RETURNS integer LANGUAGE plpgsql as $$
declare
    result integer;
    pDepPath varchar(255);
begin
    insert into t_sys_department(name,parentid,enabled)
    VALUES(depName, parentId, enabled) RETURNING id INTO result;
    execute format('select deppath from t_sys_department where id = (%s)', parentId) into pDepPath;
    --select deppath from t_sys_department where id = parentId;
    update t_sys_department set deppath=concat(pDepPath,'.',result) where id=result;
    execute format('update t_sys_department set isparent=true where id = (%s)',parentId);
    return result;
end  $$;

/**
  删除department
 */
CREATE OR REPLACE FUNCTION deleteDepartment(in did int)
    RETURNS integer LANGUAGE plpgsql as $$
declare
    result integer;
    ecount integer;
    pid integer;
    pcount integer;
    a integer;
begin
    select count(*) into a from t_sys_department where id=did and isparent=false;
    if a=0 then
        result=-2;
    else
        select count(*) into ecount from t_sys_user where departmentId=did;
        if ecount>0 then
            result=-1;
        else
            select parentid into pid from t_sys_department where id=did;
            delete from t_sys_department where id=did and isparent=false;
            select count(*) into result;
            select count(*) into pcount from t_sys_department where parentid=pid;
            if pcount=0 then update t_sys_department set isparent=false where id=pid;
            end if;
        end if;
    end if;
    return result;
end  $$;


/**
  10、雇员表
 */
DROP TABLE IF EXISTS t_sys_employee;
DROP TYPE IF EXISTS wedlock;
create type wedlock as enum('已婚','未婚','离异');
DROP TYPE IF EXISTS degree;
create type degree as enum('博士','硕士','本科','大专','高中','初中','小学','其他');
DROP TYPE IF EXISTS workstate;
create type workstate as enum('在职','离职');
CREATE TABLE t_sys_employee  (
    id              BIGSERIAL PRIMARY KEY,
    name            VARCHAR(10)  NULL DEFAULT NULL,
    gender          VARCHAR(4) NULL DEFAULT NULL,
    birthday        DATE NULL DEFAULT NULL,
    idCard          VARCHAR(18) NULL DEFAULT NULL,
    wedlock         VARCHAR(3) null DEFAULT '未婚',
    nationId        INTEGER NULL DEFAULT NULL,
    nativePlace     VARCHAR(20) NULL DEFAULT NULL,
    politicId       INTEGER NULL DEFAULT NULL,
    email           VARCHAR(64)NULL DEFAULT NULL,
    phone           VARCHAR(11) NULL DEFAULT NULL,
    address         VARCHAR(64) NULL DEFAULT NULL,
    departmentId    INTEGER NULL DEFAULT NULL,
    jobLevelId      INTEGER NULL DEFAULT NULL,
    posId           INTEGER NULL DEFAULT NULL,
    engageForm      VARCHAR(8) NULL DEFAULT NULL,
    tiptopDegree    VARCHAR(3) null default '本科',
    specialty       VARCHAR(32) NULL DEFAULT NULL,
    school          VARCHAR(32) NULL DEFAULT NULL,
    beginDate       date NULL DEFAULT NULL,
    workState       VARCHAR(3) NULL DEFAULT '在职',
    workID          VARCHAR(8) NULL DEFAULT NULL ,
    contractTerm    float NULL DEFAULT NULL,
    conversionTime  DATE NULL DEFAULT NULL,
    notWorkDate     DATE NULL DEFAULT NULL,
    beginContract   DATE NULL DEFAULT NULL,
    endContract     DATE NULL DEFAULT NULL,
    workAge         FLOAT NULL DEFAULT NULL,
    FOREIGN KEY (departmentId) REFERENCES t_sys_department (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (jobLevelId) REFERENCES t_sys_joblevel (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (posId) REFERENCES t_sys_position (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (nationId) REFERENCES t_sys_nation (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (politicId) REFERENCES t_sys_politics_status (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

COMMENT ON TABLE  t_sys_employee IS '工资表';
COMMENT ON COLUMN t_sys_employee.id IS 'ID';
COMMENT ON COLUMN t_sys_employee.name IS '名称';
COMMENT ON COLUMN t_sys_employee.gender IS '基本工资';
COMMENT ON COLUMN t_sys_employee.birthday IS '奖金';
COMMENT ON COLUMN t_sys_employee.idCard IS '午餐补助';
COMMENT ON COLUMN t_sys_employee.wedlock IS '婚姻状况';
COMMENT ON COLUMN t_sys_employee.nationId IS '民族';
COMMENT ON COLUMN t_sys_employee.nativePlace IS '籍贯';
COMMENT ON COLUMN t_sys_employee.politicId IS '政治面貌';
COMMENT ON COLUMN t_sys_employee.email IS '邮箱';
COMMENT ON COLUMN t_sys_employee.phone IS '电话';
COMMENT ON COLUMN t_sys_employee.address IS '地址';
COMMENT ON COLUMN t_sys_employee.departmentId IS '所属部门';
COMMENT ON COLUMN t_sys_employee.jobLevelId IS '职称ID';
COMMENT ON COLUMN t_sys_employee.posId IS '职位ID';
COMMENT ON COLUMN t_sys_employee.engageForm IS '聘用形式';
COMMENT ON COLUMN t_sys_employee.tiptopDegree IS '最高学历';
COMMENT ON COLUMN t_sys_employee.specialty IS '所属专业';
COMMENT ON COLUMN t_sys_employee.school IS '毕业院校';
COMMENT ON COLUMN t_sys_employee.beginDate IS '入职日期';
COMMENT ON COLUMN t_sys_employee.workState IS '在职状态';
COMMENT ON COLUMN t_sys_employee.workID IS '工号';
COMMENT ON COLUMN t_sys_employee.contractTerm IS '合同期限';
COMMENT ON COLUMN t_sys_employee.conversionTime IS '转正日期';
COMMENT ON COLUMN t_sys_employee.notWorkDate IS '离职日期';
COMMENT ON COLUMN t_sys_employee.beginContract IS '合同起始日期';
COMMENT ON COLUMN t_sys_employee.endContract IS '合同终止日期';
COMMENT ON COLUMN t_sys_employee.workAge IS '工龄';

INSERT INTO t_sys_employee VALUES (1, '韦梅', '女', '1999-11-20', '341502198810196427', '未婚', 1, '英市', 11, 'xia53@gangjing.cn', '15567487644', '贵州省洁市清城汕尾街d座 502246', 3, 5, 5, '劳动合同', '博士', '电子工程', '中国科学技术大学', '2018-10-16', '在职', '00000001', 9.31, '2018-08-29', NULL, '2017-09-03', '2019-08-26', NULL);
INSERT INTO t_sys_employee VALUES (2, '王丹', '女', '1992-03-25', '350481197304037905', '未婚', 1, '关岭市', 2, 'jieqian@yahoo.com', '18762780051', '山西省合肥县西峰香港街C座 302114', 4, 8, 2, '劳动合同', '博士', '无', '北京大学', '2018-06-25', '在职', '00000002', 9.5, '2017-08-05', NULL, '2017-05-31', '2020-01-06', NULL);
INSERT INTO t_sys_employee VALUES (3, '刘俊', '男', '1996-07-18', '130224197009132687', '未婚', 1, '萍县', 13, 'qiangfang@yahoo.com', '18663579680', '西藏自治区秀荣市海陵张家港街m座 576579', 1, 6, 1, '劳务合同', '博士', '护理学', '南京大学', '2017-08-15', '在职', '00000003', 2.53, '2016-05-25', NULL, '2015-12-21', '2019-04-21', NULL);
INSERT INTO t_sys_employee VALUES (4, '刘玉珍', '女', '1993-07-10', '512000196701014288', '未婚', 1, '雷县', 5, 'fangyang@pinggang.cn', '13972309788', '西藏自治区张家港市双滦凌街V座 614280', 4, 8, 1, '劳动合同', '博士', '市场营销', '上海交通大学', '2019-02-21', '在职', '00000004', 5.68, '2018-06-26', NULL, '2019-02-27', '2019-11-06', NULL);
INSERT INTO t_sys_employee VALUES (5, '孟秀兰', '女', '2000-01-08', '130601195204145457', '未婚', 1, '荆门县', 10, 'xliu@yahoo.com', '13319975239', '天津市辽阳市金平傅街j座 850761', 8, 4, 3, '劳动合同', '博士', '电子工程', '浙江大学', '2016-12-13', '在职', '00000005', 9.33, '2018-03-09', NULL, '2016-11-28', '2019-06-25', NULL);
INSERT INTO t_sys_employee VALUES (6, '袁秀英', '男', '1990-05-07', '110107198510132428', '未婚', 1, '合肥县', 4, 'nawu@hotmail.com', '15984781796', '重庆市兰英市高明沈阳街d座 430329', 9, 7, 2, '劳务合同', '博士', '无', '中国人民大学', '2015-10-15', '在职', '00000006', 9.2, '2016-08-30', NULL, '2019-03-21', '2019-11-30', NULL);
INSERT INTO t_sys_employee VALUES (7, '沈璐', '男', '1992-05-07', '520400196705056989', '未婚', 1, '合山县', 8, 'gaotao@hotmail.com', '14715158775', '浙江省坤县西峰余街C座 221697', 5, 6, 5, '劳务合同', '博士', '室内装修设计', '中国科学院大学', '2016-07-30', '在职', '00000007', 7.96, '2018-12-22', NULL, '2016-09-28', '2020-02-05', NULL);
INSERT INTO t_sys_employee VALUES (8, '丁艳', '男', '2001-01-29', '542100199401152966', '未婚', 1, '玲市', 10, 'yong36@gmail.com', '18878249984', '江西省南昌县双滦王路E座 490503', 8, 6, 3, '劳动合同', '博士', '信息管理与信息系统', '中国科学技术大学', '2016-05-21', '在职', '00000008', 0.25, '2017-05-06', NULL, '2015-07-28', '2019-06-05', NULL);
INSERT INTO t_sys_employee VALUES (9, '张瑞', '男', '1994-01-11', '330782198309077942', '未婚', 1, '银川市', 10, 'ping21@zengyi.net', '15510694655', '江西省太原市翔安刘街J座 815655', 12, 4, 1, '劳务合同', '博士', '信息管理与信息系统', '上海交通大学', '2018-01-15', '在职', '00000009', 4.54, '2016-04-30', NULL, '2017-02-03', '2019-08-04', NULL);
INSERT INTO t_sys_employee VALUES (10, '黄柳', '男', '1999-10-03', '45142219420818691X', '未婚', 1, '北镇市', 3, 'juanliu@jieming.cn', '14523008198', '江苏省宁县南溪王路x座 227133', 1, 1, 2, '劳务合同', '博士', '市场营销', '南京大学', '2017-06-17', '在职', '00000010', 1.46, '2016-11-03', NULL, '2016-06-07', '2019-08-24', NULL);
INSERT INTO t_sys_employee VALUES (11, '王慧', '女', '1994-07-09', '441223196008184592', '未婚', 1, '贵阳县', 8, 'xiahu@dengpan.net', '18288493616', '青海省长沙县山亭廖街v座 439792', 5, 1, 1, '劳务合同', '博士', '电子工程', '浙江大学', '2015-10-22', '在职', '00000011', 9.54, '2016-07-28', NULL, '2018-03-02', '2019-09-11', NULL);
INSERT INTO t_sys_employee VALUES (12, '田龙', '男', '1991-07-21', '621026195512050072', '未婚', 1, '敏县', 11, 'epan@hotmail.com', '13130911244', '安徽省帆市东城唐路d座 819867', 2, 7, 4, '劳务合同', '博士', '电子工程', '中国科学技术大学', '2016-06-13', '在职', '00000012', 4.95, '2019-02-15', NULL, '2018-07-28', '2019-08-27', NULL);
INSERT INTO t_sys_employee VALUES (13, '徐桂香', '男', '1997-03-06', '220101195011153893', '未婚', 1, '桂芝市', 8, 'mingxiong@guiyingna.cn', '15239681245', '广东省巢湖县和平王路V座 418151', 4, 5, 3, '劳务合同', '博士', '信息管理与信息系统', '中国人民大学', '2018-03-01', '在职', '00000013', 8.58, '2018-04-13', NULL, '2018-01-09', '2020-03-29', NULL);
INSERT INTO t_sys_employee VALUES (14, '韩桂花', '女', '1993-03-13', '451200193609248217', '已婚', 1, '丽丽市', 13, 'vzhao@la.cn', '13091676162', '澳门特别行政区东莞市高港关岭街Z座 113957', 9, 3, 1, '劳务合同', '博士', '护理学', '清华大学', '2015-08-09', '在职', '00000014', 5.9, '2016-08-08', NULL, '2017-09-04', '2019-06-23', NULL);
INSERT INTO t_sys_employee VALUES (15, '方勇', '女', '1993-03-31', '50022619560729008X', '已婚', 1, '银川县', 12, 'juan44@hotmail.com', '13599861266', '吉林省芳县南湖兰路y座 907387', 10, 3, 5, '劳务合同', '硕士', '室内装修设计', '北京大学', '2016-01-17', '在职', '00000015', 7.9, '2018-11-06', NULL, '2017-09-22', '2019-12-16', NULL);
INSERT INTO t_sys_employee VALUES (16, '徐桂芝', '女', '1999-12-07', '350627193810292241', '已婚', 1, '玉梅县', 2, 'min11@hotmail.com', '18060545344', '海南省桂荣县锡山拉萨路m座 889598', 3, 8, 4, '劳动合同', '硕士', '市场营销', '南京大学', '2015-10-11', '在职', '00000016', 8.5, '2017-10-08', NULL, '2016-01-25', '2019-09-07', NULL);
INSERT INTO t_sys_employee VALUES (17, '郭玉英', '女', '1991-05-13', '532626196803147428', '已婚', 1, '荆门市', 5, 'taozhang@hotmail.com', '13498131990', '贵州省玉英市长寿席路j座 607847', 4, 6, 4, '劳动合同', '硕士', '护理学', '清华大学', '2017-09-23', '在职', '00000017', 6.9, '2019-03-31', NULL, '2017-10-23', '2019-07-17', NULL);
INSERT INTO t_sys_employee VALUES (18, '张波', '男', '1995-07-20', '341523193305302515', '已婚', 1, '淑英县', 4, 'chao28@yahoo.com', '13198353039', '甘肃省勇县金平合山街V座 343550', 6, 1, 3, '劳务合同', '硕士', '信息管理与信息系统', '中国科学院大学', '2015-05-24', '在职', '00000018', 6.51, '2018-04-10', NULL, '2016-07-14', '2019-07-21', NULL);
INSERT INTO t_sys_employee VALUES (19, '陈桂英', '女', '1998-07-24', '320300198302021032', '已婚', 1, '西宁市', 12, 'leixiuying@lijun.cn', '15196790642', '江西省梧州县西峰林街g座 890108', 12, 2, 1, '劳务合同', '硕士', '室内装修设计', '中国人民大学', '2019-02-19', '在职', '00000019', 9.4, '2018-01-31', NULL, '2016-04-20', '2019-12-24', NULL);
INSERT INTO t_sys_employee VALUES (20, '郭慧', '男', '1997-12-27', '370784196907163913', '已婚', 1, '冬梅市', 5, 'jingyi@lilong.cn', '18748925191', '浙江省淮安市西峰周路Q座 231298', 1, 2, 3, '劳务合同', '硕士', '室内装修设计', '复旦大学', '2018-05-20', '在职', '00000020', 1.23, '2018-02-28', NULL, '2016-02-03', '2019-05-13', NULL);
INSERT INTO t_sys_employee VALUES (21, '王兰英', '女', '2001-01-14', '13062819460201540X', '已婚', 1, '北镇县', 2, 'nren@kc.cn', '13697605585', '河北省荆门县东丽徐路w座 733493', 9, 8, 3, '劳动合同', '硕士', '市场营销', '国防科技大学', '2017-11-22', '在职', '00000021', 7.2, '2017-09-14', NULL, '2018-05-04', '2019-10-11', NULL);
INSERT INTO t_sys_employee VALUES (22, '张丽丽', '女', '1993-01-11', '44011419750119469X', '已婚', 1, '桂花市', 13, 'vcao@hotmail.com', '13499132244', '江苏省颖县黄浦吴路f座 348086', 1, 6, 5, '劳动合同', '硕士', '信息管理与信息系统', '中国科学技术大学', '2018-07-27', '在职', '00000022', 1.57, '2016-08-17', NULL, '2019-03-29', '2019-12-01', NULL);
INSERT INTO t_sys_employee VALUES (23, '陈红', '女', '1991-05-07', '120101194008275509', '已婚', 1, '永安市', 4, 'fgu@hotmail.com', '14504492015', '宁夏回族自治区帆县山亭黄路Q座 528477', 9, 2, 5, '劳动合同', '硕士', '市场营销', '南京大学', '2018-06-24', '在职', '00000023', 2.32, '2016-11-21', NULL, '2018-09-15', '2020-02-11', NULL);
INSERT INTO t_sys_employee VALUES (24, '范凤英', '女', '1994-11-12', '510122194703163917', '已婚', 1, '秀兰县', 6, 'yong19@34.cn', '13973512992', '海南省梧州市滨城李路f座 504377', 8, 6, 4, '劳动合同', '硕士', '电子工程', '北京大学', '2017-07-23', '在职', '00000024', 3.52, '2017-07-30', NULL, '2016-02-23', '2019-12-07', NULL);
INSERT INTO t_sys_employee VALUES (25, '张兵', '男', '1990-09-06', '420701196603064012', '已婚', 1, '宜都市', 3, 'edeng@rd.cn', '15904360492', '西藏自治区桂珍市友好昆明街Y座 634021', 9, 6, 3, '劳务合同', '硕士', '市场营销', '中国人民大学', '2017-03-20', '在职', '00000025', 0.5, '2016-11-07', NULL, '2017-06-02', '2020-01-24', NULL);
INSERT INTO t_sys_employee VALUES (26, '黄宁', '男', '1995-06-12', '510303198712060557', '已婚', 1, '玉英县', 11, 'xiuyingpan@gmail.com', '13377122856', '广东省莉市朝阳台北街x座 190715', 6, 4, 4, '劳动合同', '硕士', '护理学', '中国科学院大学', '2017-05-09', '在职', '00000026', 7.72, '2017-01-24', NULL, '2018-06-07', '2019-10-31', NULL);
INSERT INTO t_sys_employee VALUES (27, '黄荣', '女', '1997-08-04', '14060319870325316X', '已婚', 1, '大冶市', 1, 'ihao@yahoo.com', '14528832529', '江西省六安县和平永安街r座 137243', 9, 4, 1, '劳务合同', '硕士', '无', '浙江大学', '2018-09-29', '在职', '00000027', 6.16, '2017-11-25', NULL, '2017-12-14', '2019-12-29', NULL);
INSERT INTO t_sys_employee VALUES (28, '周雷', '男', '2001-12-03', '411201197212305874', '已婚', 1, '六安市', 7, 'ping89@wg.cn', '14550266014', '浙江省丹县黄浦北镇路G座 186275', 6, 4, 3, '劳动合同', '硕士', '电子工程', '中国科学院大学', '2017-10-04', '在职', '00000028', 8.14, '2018-04-18', NULL, '2018-03-07', '2020-03-20', NULL);
INSERT INTO t_sys_employee VALUES (29, '周静', '女', '2001-03-14', '640105199111105559', '已婚', 1, '雪梅县', 6, 'xiajing@yahoo.com', '18912358599', '山西省瑜县怀柔北京路p座 691913', 6, 6, 4, '劳务合同', '硕士', '护理学', '北京大学', '2018-02-28', '在职', '00000029', 1.4, '2018-10-20', NULL, '2017-05-04', '2020-01-05', NULL);
INSERT INTO t_sys_employee VALUES (30, '师婷婷', '男', '1998-09-14', '500241199402197190', '已婚', 1, '沈阳县', 2, 'pcui@hotmail.com', '14572285539', '福建省海口县江北陈路H座 259607', 5, 4, 4, '劳动合同', '本科', '信息管理与信息系统', '南京大学', '2017-02-22', '在职', '00000030', 8.7, '2018-11-17', NULL, '2018-07-07', '2019-05-26', NULL);
INSERT INTO t_sys_employee VALUES (31, '邹平', '男', '1995-07-18', '469023197609079864', '已婚', 1, '沈阳县', 7, 'qiang09@hotmail.com', '15711044116', '甘肃省丽丽县永川石家庄街w座 788572', 13, 2, 2, '劳务合同', '本科', '市场营销', '浙江大学', '2019-02-27', '在职', '00000031', 0.22, '2019-01-15', NULL, '2017-04-12', '2019-05-02', NULL);
INSERT INTO t_sys_employee VALUES (32, '蒋桂兰', '男', '2002-01-03', '451000198103141393', '已婚', 1, '通辽县', 2, 'xuli@yahoo.com', '14747861689', '台湾省斌县大兴潮州街Q座 620273', 5, 6, 1, '劳务合同', '本科', '电子工程', '浙江大学', '2019-01-30', '在职', '00000032', 4.11, '2018-09-26', NULL, '2015-05-16', '2019-05-13', NULL);
INSERT INTO t_sys_employee VALUES (33, '何燕', '女', '1995-10-03', '211081194006172759', '已婚', 1, '伟市', 9, 'pqin@yahoo.com', '14510585247', '宁夏回族自治区健市和平蔡街X座 666462', 9, 6, 1, '劳动合同', '本科', '护理学', '复旦大学', '2018-05-08', '在职', '00000033', 9.4, '2017-03-17', NULL, '2017-07-12', '2019-10-22', NULL);
INSERT INTO t_sys_employee VALUES (34, '马淑珍', '女', '2001-07-07', '130604198910150088', '已婚', 1, '成县', 7, 'leizou@yahoo.com', '13164981755', '湖北省太原县魏都安街c座 530374', 9, 8, 3, '劳动合同', '本科', '市场营销', '中国科学院大学', '2019-03-12', '在职', '00000034', 2.67, '2018-10-18', NULL, '2018-12-22', '2020-04-04', NULL);
