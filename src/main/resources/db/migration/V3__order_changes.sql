ALTER TABLE orders
DROP
FOREIGN KEY FK_ORDER_REVIEW;

ALTER TABLE shipping
DROP
FOREIGN KEY FK_SHIPPING_ORDER;

ALTER TABLE orders
    ADD payment_id BIGINT NULL;

ALTER TABLE orders
    ADD shipping_id BIGINT NULL;

ALTER TABLE orders
    ADD status_id BIGINT NULL;

ALTER TABLE orders
    ADD CONSTRAINT uc_orders_payment UNIQUE (payment_id);

ALTER TABLE orders
    ADD CONSTRAINT uc_orders_shipping UNIQUE (shipping_id);

ALTER TABLE orders
    ADD CONSTRAINT uc_orders_status UNIQUE (status_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDER_PAYMENT FOREIGN KEY (payment_id) REFERENCES payment (payment_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDER_SHIPPING FOREIGN KEY (shipping_id) REFERENCES shipping (shipping_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDER_STATUS FOREIGN KEY (status_id) REFERENCES order_status (status_id);

ALTER TABLE shipping
DROP
COLUMN order_id;

ALTER TABLE orders
DROP
COLUMN review_id;