/**
  1、客户表
 */
DROP TABLE IF EXISTS t_customer;
CREATE TABLE t_customer(
    id SERIAL PRIMARY KEY NOT NULL,
    name      TEXT NOT NULL,
    age       INT  NOT NULL,
    address   VARCHAR(50),
    createdAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updatedAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
COMMENT ON TABLE  t_customer IS '客户表';
COMMENT ON COLUMN t_customer.id IS 'ID';
COMMENT ON COLUMN t_customer.name IS '客户名';
COMMENT ON COLUMN t_customer.age IS '客户年龄';
COMMENT ON COLUMN t_customer.address IS '客户地址';
COMMENT ON COLUMN t_customer.createdAt IS '数据新建时间';
COMMENT ON COLUMN t_customer.updatedAt IS '数据更新时间';

/**
  2、邮件表
 */
DROP TABLE IF EXISTS t_mail_log;
CREATE TABLE t_mail_log(
   id SERIAL PRIMARY KEY NOT NULL,
   mailto VARCHAR(100) NOT NULL,
   content   VARCHAR(500),
   createdAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
COMMENT ON TABLE  t_mail_log IS '邮件日志表';
COMMENT ON COLUMN t_mail_log.id IS 'ID';
COMMENT ON COLUMN t_mail_log.mailto IS '客户名';
COMMENT ON COLUMN t_mail_log.content IS '邮件内容';
COMMENT ON COLUMN t_mail_log.createdAt IS '数据新建时间';

/**
  3、Quartz定时任务表
 */
DROP TABLE IF EXISTS t_task_config;
CREATE TABLE t_task_config
(
    id          SERIAL PRIMARY KEY NOT NULL,
    task_id     VARCHAR(8)         NOT NULL,
    cron        VARCHAR(20)        NOT NULL,
    class_name  VARCHAR(255)       NOT NULL,
    description VARCHAR(255)       NOT NULL,
    status      INTEGER            NOT NULL,
    createdAt   timestamp(3)       NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
COMMENT ON TABLE  t_task_config IS '定时任务表';
COMMENT ON COLUMN t_task_config.id IS 'ID';
COMMENT ON COLUMN t_task_config.task_id IS '任务id';
COMMENT ON COLUMN t_task_config.cron IS 'CRON表达式';
COMMENT ON COLUMN t_task_config.class_name IS 'job引用地址';
COMMENT ON COLUMN t_task_config.description IS '描述';
COMMENT ON COLUMN t_task_config.status IS '定时任务状态 0 停用,1启用';
COMMENT ON COLUMN t_task_config.createdAt IS '数据新建时间';

INSERT INTO t_task_config (task_id, cron, class_name, description, status) VALUES ('TB00001', '*/600 * * * * ?', 'cn.geoportal.gmo.server.job.MyJob', '每一分钟触发一次', '1');

/**
  4、shopInfo空间表
 */
DROP TABLE IF EXISTS t_shopInfo;
DROP INDEX IF EXISTS idx_t_shopInfo_geom;
CREATE TABLE t_shopInfo(
    id SERIAL PRIMARY KEY NOT NULL,
    name      TEXT NOT NULL,
    address   VARCHAR(50),
    lat real,
    lng real,
    geom geometry(Point, 4326),
    createdAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updatedAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);
CREATE INDEX idx_t_shopInfo_geom ON t_shopInfo USING gist(geom);

COMMENT ON TABLE  t_shopInfo IS '商店空间表';
COMMENT ON COLUMN t_shopInfo.id IS 'ID';
COMMENT ON COLUMN t_shopInfo.name IS '名称';
COMMENT ON COLUMN t_shopInfo.address IS '地址';
COMMENT ON COLUMN t_shopInfo.lat IS '纬度';
COMMENT ON COLUMN t_shopInfo.lng IS '经度';
COMMENT ON COLUMN t_shopInfo.geom IS '时空位置';
COMMENT ON COLUMN t_shopInfo.createdAt IS '数据新建时间';
COMMENT ON COLUMN t_shopInfo.updatedAt IS '数据更新时间';

INSERT INTO t_shopInfo (name, address, lat, lng, geom) VALUES ('南京农业大学', '技术南京', 32.033371, 118.843587, ST_GeomFromText('POINT(118.843587 32.033371)', 4326));
INSERT INTO t_shopInfo (name, address, lat, lng, geom) VALUES ('南京理工大学', '技术南京', 32.028154, 118.856517, ST_GeomFromText('POINT(118.856517 32.028154)', 4326));
INSERT INTO t_shopInfo (name, address, lat, lng, geom) VALUES ('南京体育学院', '技术南京', 32.044067, 118.866954, ST_GeomFromText('POINT(118.866954 32.044067)', 4326));
INSERT INTO t_shopInfo (name, address, lat, lng, geom) VALUES ('江苏农业科学院', '技术南京', 32.033437, 118.874588, ST_GeomFromText('POINT(118.874588 32.033437)', 4326));
INSERT INTO t_shopInfo (name, address, lat, lng, geom) VALUES ('南京博物院', '技术南京', 32.040766, 118.825048, ST_GeomFromText('POINT(118.825048 32.040766)', 4326));
INSERT INTO t_shopInfo (name, address, lat, lng, geom) VALUES ('南京东郊国宾馆', '技术南京', 32.05978, 118.847481, ST_GeomFromText('POINT(118.847481 32.05978)', 4326));
