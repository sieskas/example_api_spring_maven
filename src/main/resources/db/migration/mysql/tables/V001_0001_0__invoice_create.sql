CREATE TABLE invoice
(
    id_invoice INT auto_increment NOT NULL,
    num_account varchar(100) NOT NULL,
    CONSTRAINT invoice_PK PRIMARY KEY (id_invoice)
)