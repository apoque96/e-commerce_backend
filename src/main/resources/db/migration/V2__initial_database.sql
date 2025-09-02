ALTER TABLE customer
DROP
COLUMN customer_id;

ALTER TABLE customer
    ADD customer_id VARCHAR(255) NOT NULL PRIMARY KEY;

CREATE TABLE address
(
    address_id     BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    updated_at     datetime NULL,
    deleted_at     datetime NULL,
    customer_id    VARCHAR(255) NOT NULL,
    street_address VARCHAR(255) NOT NULL,
    zip_code       VARCHAR(20)  NOT NULL,
    city           VARCHAR(100) NOT NULL,
    country        VARCHAR(100) NOT NULL,
    state          VARCHAR(100) NOT NULL,
    address_type   VARCHAR(50)  NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (address_id)
);

CREATE TABLE authority
(
    authority_id BIGINT       NOT NULL,
    authority    VARCHAR(255) NOT NULL,
    customer_id  VARCHAR(255) NULL,
    CONSTRAINT pk_authority PRIMARY KEY (authority_id)
);

CREATE TABLE category
(
    category_id   BIGINT       NOT NULL,
    created_at    datetime     NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    name          VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (category_id)
);

CREATE TABLE coupon
(
    coupon_id   BIGINT      NOT NULL,
    coupon_code VARCHAR(20) NOT NULL,
    discount_amount DOUBLE NOT NULL,
    CONSTRAINT pk_coupon PRIMARY KEY (coupon_id)
);

CREATE TABLE extra_info
(
    extra_info_id VARCHAR(255) NOT NULL,
    created_at    datetime     NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    packaging     VARCHAR(255) NULL,
    weight        VARCHAR(255) NULL,
    height        VARCHAR(255) NULL,
    width         VARCHAR(255) NULL,
    information   TEXT NULL,
    CONSTRAINT pk_extra_info PRIMARY KEY (extra_info_id)
);

CREATE TABLE order_product
(
    order_product_id BIGINT       NOT NULL,
    created_at       datetime     NOT NULL,
    updated_at       datetime NULL,
    deleted_at       datetime NULL,
    product_id       VARCHAR(255) NOT NULL,
    order_id         BIGINT       NOT NULL,
    quantity         INT          NOT NULL,
    total_price DOUBLE NOT NULL,
    color            VARCHAR(50) NULL,
    CONSTRAINT pk_order_product PRIMARY KEY (order_product_id)
);

CREATE TABLE order_status
(
    status_id     BIGINT      NOT NULL,
    created_at    datetime    NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    status_name   VARCHAR(50) NOT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_order_status PRIMARY KEY (status_id)
);

CREATE TABLE orders
(
    order_id    BIGINT       NOT NULL,
    created_at  datetime     NOT NULL,
    updated_at  datetime NULL,
    deleted_at  datetime NULL,
    customer_id VARCHAR(255) NOT NULL,
    coupon_id   BIGINT NULL,
    review_id   BIGINT NULL,
    subtotal_amount DOUBLE NOT NULL,
    total_amount DOUBLE NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (order_id)
);

CREATE TABLE payment
(
    payment_id    BIGINT   NOT NULL,
    created_at    datetime NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    amount DOUBLE NOT NULL,
    payment_date  datetime NOT NULL,
    bill_name     VARCHAR(100) NULL,
    `description` VARCHAR(255) NULL,
    method_id     BIGINT NULL,
    status_id     BIGINT NULL,
    CONSTRAINT pk_payment PRIMARY KEY (payment_id)
);

CREATE TABLE payment_method
(
    method_id     BIGINT      NOT NULL,
    created_at    datetime    NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    name          VARCHAR(50) NOT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_payment_method PRIMARY KEY (method_id)
);

CREATE TABLE payment_status
(
    status_id     BIGINT      NOT NULL,
    created_at    datetime    NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    name          VARCHAR(50) NOT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_payment_status PRIMARY KEY (status_id)
);

CREATE TABLE product
(
    product_id     VARCHAR(255) NOT NULL,
    created_at     datetime     NOT NULL,
    updated_at     datetime NULL,
    deleted_at     datetime NULL,
    category_id    BIGINT NULL,
    extra_info_id  VARCHAR(255) NULL,
    name           VARCHAR(255) NOT NULL,
    discount DOUBLE NOT NULL,
    discount_amount DOUBLE NOT NULL,
    measurements   VARCHAR(255) NULL,
    `description`  TEXT         NOT NULL,
    price DOUBLE NOT NULL,
    stock_quantity INT          NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (product_id)
);

CREATE TABLE product_images
(
    product_image_id BIGINT       NOT NULL,
    created_at       datetime     NOT NULL,
    updated_at       datetime NULL,
    deleted_at       datetime NULL,
    product_id       VARCHAR(255) NULL,
    color            VARCHAR(255) NULL,
    image_name       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_product_images PRIMARY KEY (product_image_id)
);

CREATE TABLE reply
(
    reply_id   BIGINT        NOT NULL,
    created_at datetime      NOT NULL,
    updated_at datetime NULL,
    deleted_at datetime NULL,
    review_id  BIGINT        NOT NULL,
    comment    VARCHAR(1000) NOT NULL,
    CONSTRAINT pk_reply PRIMARY KEY (reply_id)
);

CREATE TABLE review
(
    review_id        BIGINT        NOT NULL,
    created_at       datetime      NOT NULL,
    updated_at       datetime NULL,
    deleted_at       datetime NULL,
    customer_id      VARCHAR(255)  NOT NULL,
    order_product_id BIGINT        NOT NULL,
    comment          VARCHAR(4000) NOT NULL,
    rating           INT           NOT NULL,
    CONSTRAINT pk_review PRIMARY KEY (review_id)
);

CREATE TABLE shipping
(
    shipping_id   BIGINT      NOT NULL,
    created_at    datetime    NOT NULL,
    updated_at    datetime NULL,
    deleted_at    datetime NULL,
    order_id      BIGINT      NOT NULL,
    shipping_type VARCHAR(50) NOT NULL,
    shipping_price DOUBLE NOT NULL,
    CONSTRAINT pk_shipping PRIMARY KEY (shipping_id)
);

CREATE TABLE wishlist
(
    wishlist_id BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime NULL,
    updated_at  datetime NULL,
    deleted_at  datetime NULL,
    customer_id VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NULL,
    CONSTRAINT pk_wishlist PRIMARY KEY (wishlist_id)
);

CREATE TABLE wishlist_products
(
    wishlist_product_id BIGINT AUTO_INCREMENT NOT NULL,
    created_at          datetime NULL,
    updated_at          datetime NULL,
    deleted_at          datetime NULL,
    wishlist_id         BIGINT       NOT NULL,
    product_id          VARCHAR(255) NOT NULL,
    CONSTRAINT pk_wishlist_products PRIMARY KEY (wishlist_product_id)
);

ALTER TABLE customer
    ADD password_hash VARCHAR(255) NULL;

ALTER TABLE customer
    MODIFY password_hash VARCHAR (255) NOT NULL;

ALTER TABLE wishlist
    ADD CONSTRAINT uc_8d409843b2a4f5adfbe8c9ba4 UNIQUE (customer_id);

ALTER TABLE coupon
    ADD CONSTRAINT uc_coupon_couponcode UNIQUE (coupon_code);

ALTER TABLE wishlist_products
    ADD CONSTRAINT uc_ebd23fa8a9043174078f67a14 UNIQUE (wishlist_id, product_id);

ALTER TABLE order_status
    ADD CONSTRAINT uc_order_status_statusname UNIQUE (status_name);

ALTER TABLE payment
    ADD CONSTRAINT uc_payment_method UNIQUE (method_id);

ALTER TABLE payment_method
    ADD CONSTRAINT uc_payment_method_name UNIQUE (name);

ALTER TABLE payment
    ADD CONSTRAINT uc_payment_status UNIQUE (status_id);

ALTER TABLE payment_status
    ADD CONSTRAINT uc_payment_status_name UNIQUE (name);

ALTER TABLE product
    ADD CONSTRAINT uc_product_extra_info UNIQUE (extra_info_id);

ALTER TABLE product_images
    ADD CONSTRAINT uc_product_images_imagename UNIQUE (image_name);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

CREATE INDEX idx_address_customer ON address (customer_id);

ALTER TABLE authority
    ADD CONSTRAINT FK_AUTHORITY_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDER_COUPON FOREIGN KEY (coupon_id) REFERENCES coupon (coupon_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE order_product
    ADD CONSTRAINT FK_ORDER_PRODUCT_ORDER FOREIGN KEY (order_id) REFERENCES orders (order_id);

ALTER TABLE order_product
    ADD CONSTRAINT FK_ORDER_PRODUCT_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDER_REVIEW FOREIGN KEY (review_id) REFERENCES review (review_id);

ALTER TABLE payment
    ADD CONSTRAINT FK_PAYMENT_ON_METHOD FOREIGN KEY (method_id) REFERENCES payment_method (method_id);

ALTER TABLE payment
    ADD CONSTRAINT FK_PAYMENT_ON_STATUS FOREIGN KEY (status_id) REFERENCES payment_status (status_id);

ALTER TABLE product_images
    ADD CONSTRAINT FK_PRODUCT_IMAGES_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (category_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_EXTRA_INFO FOREIGN KEY (extra_info_id) REFERENCES extra_info (extra_info_id);

ALTER TABLE reply
    ADD CONSTRAINT FK_REPLY_ON_REVIEW FOREIGN KEY (review_id) REFERENCES review (review_id);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_ORDER_PRODUCT FOREIGN KEY (order_product_id) REFERENCES order_product (order_product_id);

ALTER TABLE shipping
    ADD CONSTRAINT FK_SHIPPING_ORDER FOREIGN KEY (order_id) REFERENCES orders (order_id);

ALTER TABLE wishlist
    ADD CONSTRAINT FK_WISHLIST_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE wishlist_products
    ADD CONSTRAINT FK_WISHLIST_PRODUCTS_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE wishlist_products
    ADD CONSTRAINT FK_WISHLIST_PRODUCTS_WISHLIST FOREIGN KEY (wishlist_id) REFERENCES wishlist (wishlist_id);