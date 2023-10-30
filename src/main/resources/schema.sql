create table demo_orders_tbl
(
    order_id     varchar(64),
    succeed      tinyint(1) default 0,
    order_status varchar(32),
    create_time  datetime(6),
    CONSTRAINT demo_orders_tbl_order_id_pk PRIMARY KEY (order_id)
);

create table demo_items_tbl
(
    id           int auto_increment primary key,
    order_id     varchar(64),
    sku_id       varchar(64),
    shop_url     varchar(64),
    purchase_num int            default 0,
    price        int            default 0,
    tax          decimal(10, 2) DEFAULT '0.00',
    create_time  datetime(6),
    foreign key (order_id) references demo_orders_tbl (order_id)
);