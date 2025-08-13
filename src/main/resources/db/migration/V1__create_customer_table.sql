CREATE TABLE customer
(
    customer_id       BINARY(16)   NOT NULL,
    registration_date datetime     NOT NULL,
    username          VARCHAR(255) NOT NULL,
    email             VARCHAR(255) NOT NULL,
    phone_number      VARCHAR(255) NULL,
    first_name        VARCHAR(255) NOT NULL,
    last_name         VARCHAR(255) NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_email UNIQUE (email);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_username UNIQUE (username);