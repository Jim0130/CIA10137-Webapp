create database if not exists ezban;

use ezban;

-- member表格暫時簡單建立，為了product_order的FK需求而建立。
create table member
(
    member_no int primary key auto_increment not null
);
insert into member (member_no) values (1);
insert into member (member_no) values (2);
insert into member (member_no) values (3);
insert into member (member_no) values (4);
insert into member (member_no) values (5);

-- birthday_coupon表格暫時簡單建立，為了product_order的FK需求而建立。
create table birthday_coupon
(
    birthday_coupon_no int primary key auto_increment not null
);
insert into birthday_coupon (birthday_coupon_no) values (1);


create table product_order
(
    product_order_no                int primary key auto_increment not null,
    member_no                       int   not   null,
    product_price                   int   not   null,
    product_coupon_discount         int default null,
    product_checkout_amount         int   not   null,
    member_points                   int default null,
    birthday_coupon_no              int default null,
    recipient                       varchar(50)  not null,
    recipient_phone                 varchar(15)  not null,
    recipient_address               varchar(200) not null,
    product_orderdate               DateTime,
    product_paydate                 DateTime,
    order_closedate                 DateTime,
    product_payment_status          tinyint default '0',
    product_process_status          tinyint default '0',
    product_order_allocation_amount int,
    product_order_allocation_status tinyint default '0',
    foreign key (member_no) references member (member_no),
    foreign key (birthday_coupon_no) references birthday_coupon (birthday_coupon_no)
);

insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (1, 249, null, 249, null, null, '大王', '0913245678', '桃園市中壢區10號', '2024-03-01 01:01:01','2024-03-01 01:02:01', null, 1, 0, 220, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (2, 199, null, 190, 9,    null, '大林', '0923245678', '桃園市中壢區11號', '2024-03-04 02:01:01','2024-03-04 02-02-01', null, 0, 0, 170, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (3, 299, null, 199, null,   1,  '大葉', '0933245678', '桃園市中壢區12號', '2024-03-14 03:01:01','2024-03-14 03:02:01', null, 1, 2, 270, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (4, 499,  100, 299, null,   1,  '大孫', '0943245678', '桃園市中壢區13號', '2024-03-24 04:01:01','2024-03-24 04:02:01', null, 1, 0, 370, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (5, 499,  100, 399, null, null, '大徐', '0953245678', '桃園市中壢區14號', '2024-03-31 05:01:01','2024-03-31 05:02:01', null, 1, 2, 370, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (1, 168, null, 68,  null,   1,  '大王', '0913245678', '桃園市中壢區10號', '2024-04-01 06:01:01','2024-04-01 06:02:01', null, 0, 0, 140, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (2, 499,  100, 399, null, null, '大林', '0923245678', '桃園市中壢區11號', '2024-04-01 07:01:01','2024-04-01 07:02:01', null, 0, 0, 470, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (3, 499, null, 400, 99,   null, '大葉', '0933245678', '桃園市中壢區12號', '2024-04-02 08:01:01','2024-04-02 08:02:01', null, 1, 2, 470, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (4, 399, null, 399, null, null, '大孫', '0943245678', '桃園市中壢區13號', '2024-04-02 09:01:01','2024-04-02 09:02:01', null, 1, 2, 370, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (5, 299, null, 190, 9,      1,  '大徐', '0953245678', '桃園市中壢區14號', '2024-04-02 10:01:01','2024-04-02 10:02:01', null, 0, 0, 270, 0);
