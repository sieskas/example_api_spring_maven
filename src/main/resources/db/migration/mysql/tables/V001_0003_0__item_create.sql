CREATE TABLE Item
(
    id_item     INT auto_increment NOT NULL,
    name        varchar(100)       NOT NULL,
    id_type     INT(100)           NOT NULL,
    num_account varchar(100)       NOT NULL,
    price       DECIMAL            NOT NULL,
    CONSTRAINT Item_PK PRIMARY KEY (id_item),
    CONSTRAINT Item_FK FOREIGN KEY (num_account) REFERENCES Invoice (num_Account),
    CONSTRAINT Item_FK_1 FOREIGN KEY (id_type) REFERENCES TypeEnum (id_type)
)