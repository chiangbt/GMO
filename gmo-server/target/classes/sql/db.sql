/**
  客户表
 */
CREATE TABLE t_customer(
    id SERIAL PRIMARY KEY     NOT NULL,
    name      TEXT    NOT NULL,
    age       INT     NOT NULL,
    address   VARCHAR(50),
    createdAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    updatedAt timestamp(3) NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);