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


set auto_increment_offset=1001;
set auto_increment_increment=1;
create table product_order
(
    product_order_no                int primary key auto_increment not null,
    member_no                       int     not null,
    product_price                   int     not null,
    product_coupon_discount         int default null,
    product_checkout_amount         int     not null,
    member_points                   int default null,
    birthday_coupon_no              int default null,
    recipient                       varchar(50)  not null,
    recipient_phone                 varchar(15)  not null,
    recipient_address               varchar(200) not null,
    product_orderdate               dateTime default now(),
    product_paydate                 dateTime default now(),
    order_closedate                 dateTime default null,
    product_payment_status          tinyint 	 not null,
    product_process_status          tinyint 	 not null,
    product_order_allocation_amount     int not null,
    product_order_allocation_status tinyint not null,
    foreign key (member_no) references member (member_no),
    foreign key (birthday_coupon_no) references birthday_coupon (birthday_coupon_no)
)auto_increment = 1001;
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (1, 5000, null, 5000, null, null, '葉先森', '0912345678', '桃園市中壢區11號', now(), now(), null, 1, 4, 4950, 1);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (2, 4000, null, 3950,   50, null, '陳曉捷', '0922345678', '桃園市中壢區12號', now(), now(), null, 1, 2, 3950, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (3, 3000, null, 2900,  100, null, '余鮮聲', '0932345678', '桃園市中壢區13號', now(), now(), null, 1, 0, 2950, 0);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (4, 2000,  100, 1900, null,    1, '黃仙聲', '0942345678', '桃園市中壢區14號', now(), now(), null, 1, 2, 1950, 1);
insert into product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) values (5, 1000,  100,  900, null,    1, '王子森', '0952345678', '桃園市中壢區15號', now(), now(), null, 1, 0,  950, 0);


-- product表格暫時簡單建立，為了product_order_detail的FK需求而建立。
create table product
(
	product_no int primary key auto_increment not null
);
insert into product (product_no) values (1);
insert into product (product_no) values (2);
insert into product (product_no) values (3);
insert into product (product_no) values (4);
insert into product (product_no) values (5);


create table product_order_detail
(
	product_no          int not null,
    product_order_no    int not null,
    product_qty	        int not null,
    product_price       int not null,
	comments_status tinyint not null,
	primary key (product_no, product_order_no),
    foreign key (product_no) references product (product_no),
    foreign key (product_order_no) references product_order (product_order_no)  
);
insert into product_order_detail (product_no, product_order_no, product_qty, product_price, comments_status) values (1, 1001, 4, 5000, 0);
insert into product_order_detail (product_no, product_order_no, product_qty, product_price, comments_status) values (2, 1002, 4, 3950, 1);
insert into product_order_detail (product_no, product_order_no, product_qty, product_price, comments_status) values (3, 1003, 2, 2900, 1);
insert into product_order_detail (product_no, product_order_no, product_qty, product_price, comments_status) values (4, 1004, 3, 1900, 0);
insert into product_order_detail (product_no, product_order_no, product_qty, product_price, comments_status) values (5, 1005, 2,  900, 0);



create table save_product
(
	member_no int not null,
    product_no int not null,
	primary key (member_no,product_no),
	foreign key (member_no) references member (member_no),
    foreign key (product_no) references product (product_no)
);
insert into save_product (member_no, product_no) values (1, 1);
insert into save_product (member_no, product_no) values (2, 2);
insert into save_product (member_no, product_no) values (3, 3);
insert into save_product (member_no, product_no) values (4, 4);
insert into save_product (member_no, product_no) values (5, 5);


-- admin表格暫時簡單建立，為了product_report的FK需求而建立。
create table admin
(
    admin_no int primary key auto_increment not null
);
insert into admin (admin_no) values (1);
insert into admin (admin_no) values (2);
insert into admin (admin_no) values (3);
insert into admin (admin_no) values (4);
insert into admin (admin_no) values (5);


create table product_report
(
	product_report_no int primary key auto_increment not null,
    product_no int not null,
    member_no int not null,
    admin_no int not null,
	report_reason varchar(100) not null,
	report_date datetime default now(),
	report_status tinyint not null,
	foreign key (product_no) references product (product_no),
	foreign key (member_no) references member (member_no),
	foreign key (admin_no) references admin (admin_no)
);
insert into product_report (product_no, member_no, admin_no, report_reason, report_date, report_status) values (1, 1, 1,       '內有不雅字眼',  now(), 0);
insert into product_report (product_no, member_no, admin_no, report_reason, report_date, report_status) values (2, 1, 2,         '價格不合理', now(), 1);
insert into product_report (product_no, member_no, admin_no, report_reason, report_date, report_status) values (3, 2, 3,     '商品名稱太難聽',  now(), 1);
insert into product_report (product_no, member_no, admin_no, report_reason, report_date, report_status) values (4, 3, 4,       '我完全用不到', now(), 1);
insert into product_report (product_no, member_no, admin_no, report_reason, report_date, report_status) values (5, 3, 5, '就是想檢舉這樣商品',   now(), 0);


-- =======PHTOT UPLOAD TEST======= 

-- create table running_type_photo
-- (
--	product_img_no		int primary key auto_increment not null,
--	product_no    		int not null,
--	product_img			LongBlob,
--	foreign key (product_no) references product (product_no)	
-- );
--
-- insert into running_type_photo(product_img_no, product_no, product_img) values (1, 1,null);
-- insert into running_type_photo(product_img_no, product_no, product_img) values (2, 2,null);
-- insert into running_type_photo(product_img_no, product_no, product_img) values (3, 3,null);