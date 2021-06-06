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