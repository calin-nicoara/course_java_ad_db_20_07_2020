CREATE SEQUENCE PRODUCT_SEQ;
CREATE SEQUENCE STORE_PRODUCT_SEQ;

CREATE TABLE product (
     id bigint primary key,
     name varchar(255),
     price  decimal(10, 2),
     brand varchar(255)
);

CREATE TABLE store_product (
    id bigint primary key,
    stock integer,
    store_id bigint,
    product_id bigint,
    FOREIGN KEY (product_id) REFERENCES product(id)
);
