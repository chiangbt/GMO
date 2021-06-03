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
COMMENT ON table  t_customer is '客户表';
COMMENT ON COLUMN t_customer.id is 'ID';
COMMENT ON COLUMN t_customer.name is '客户名';
COMMENT ON COLUMN t_customer.age is '客户年龄';
COMMENT ON COLUMN t_customer.address is '客户地址';
COMMENT ON COLUMN t_customer.createdAt is '数据新建时间';
COMMENT ON COLUMN t_customer.updatedAt is '数据更新时间';