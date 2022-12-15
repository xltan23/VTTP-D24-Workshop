purchase_order table: [order_id, name, order_date, tax]
create table purchase_order (
	order_id char(8) not null,
    name varchar(128) not null,
    order_date date not null,
    tax decimal(2,2) default 0.05, 
    primary key(order_id)
);

line_item table: [item_id, description, quantity, order_id]
create table line_item (
	item_id int auto_increment not null,
    description text not null,
    quantity int,
    order_id char(8) not null,
    primary key(item_id),
    constraint fk_order_id
		foreign key(order_id) references purchase_order(order_id)
);