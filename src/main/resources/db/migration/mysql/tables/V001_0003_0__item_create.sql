CREATE TABLE item
(
    id_item    INT auto_increment NOT NULL,
    name       varchar(100)       NOT NULL,
    id_type    INT(100)           NOT NULL,
    id_invoice INT(100),
    price      DECIMAL            NOT NULL,
    CONSTRAINT item_PK PRIMARY KEY (id_item),
    CONSTRAINT item_FK FOREIGN KEY (id_invoice) REFERENCES invoice (id_invoice),
    CONSTRAINT item_FK_1 FOREIGN KEY (id_type) REFERENCES type_item (id_type)
)