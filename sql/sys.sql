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