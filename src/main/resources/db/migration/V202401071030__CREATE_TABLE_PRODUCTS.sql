create schema if not exists ecomm_products;

create table ecomm_products.tb_product(
    product_id serial primary key,
    display_name varchar(100) not null,
    sale_price numeric(15, 2),
    list_price numeric(15, 2) not null,
    category varchar(50) not null,
    width double precision not null,
    weight double precision not null,
    height double precision not null,
    created_at timestamp without time zone not null,
    updated_at timestamp without time zone not null
);

alter table ecomm_products.tb_product owner to admin;
grant all on table ecomm_products.tb_product to admin;
grant select,insert,update,delete on table ecomm_products.tb_product to admin;

create table ecomm_products.tb_product_images(
    product_image_id serial primary key,
    product_id bigint not null,
    image_hash varchar(200) not null,
    extension varchar(10) not null
);

alter table ecomm_products.tb_product_images owner to admin;
grant all on table ecomm_products.tb_product_images to admin;
grant select,insert,update,delete on table ecomm_products.tb_product_images to admin;