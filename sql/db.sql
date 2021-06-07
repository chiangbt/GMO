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
COMMENT ON table  t_customer IS '客户表';
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
COMMENT ON table  t_mail_log IS '邮件日志表';
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
COMMENT ON table  t_task_config IS '定时任务表';
COMMENT ON COLUMN t_task_config.id IS 'ID';
COMMENT ON COLUMN t_task_config.task_id IS '任务id';
COMMENT ON COLUMN t_task_config.cron IS 'CRON表达式';
COMMENT ON COLUMN t_task_config.class_name IS 'job引用地址';
COMMENT ON COLUMN t_task_config.description IS '描述';
COMMENT ON COLUMN t_task_config.status IS '定时任务状态 0 停用,1启用';
COMMENT ON COLUMN t_task_config.createdAt IS '数据新建时间';
