insert into demo_orders_tbl (order_id, succeed, order_status, create_time) values ('order_1', 1, 'place order succeed', current_date);
insert into demo_orders_tbl (order_id, succeed, order_status, create_time) values ('order_2', 1, 'place order succeed', current_date);
insert into demo_orders_tbl (order_id, succeed, order_status, create_time) values ('order_3', 0, 'place order failed', current_date);

insert into demo_items_tbl (id, order_id, sku_id, shop_url, purchase_num, price, tax, create_time) values (1, 'order_1', 'sku_1', 'shop_1', 1, 1000, 0.1, current_date);
insert into demo_items_tbl (id, order_id, sku_id, shop_url, purchase_num, price, tax, create_time) values (2, 'order_1', 'sku_2', 'shop_2', 2, 2000, 0.2, current_date);
insert into demo_items_tbl (id, order_id, sku_id, shop_url, purchase_num, price, tax, create_time) values (3, 'order_2', 'sku_1', 'shop_1', 5, 1000, 0.1, current_date);
insert into demo_items_tbl (id, order_id, sku_id, shop_url, purchase_num, price, tax, create_time) values (4, 'order_2', 'sku_2', 'shop_1', 1, 1000, 0.1, current_date);
insert into demo_items_tbl (id, order_id, sku_id, shop_url, purchase_num, price, tax, create_time) values (5, 'order_3', 'sku_3', 'shop_3', 1, 1000, 0.08, current_date);
