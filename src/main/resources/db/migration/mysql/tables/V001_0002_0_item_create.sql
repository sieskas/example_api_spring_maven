CREATE TABLE Item
(
    id         INT            NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255)   NOT NULL,
    type_id    INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    numAccount VARCHAR(255)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (numAccount) REFERENCES Invoice (numAccount),
    FOREIGN KEY (type_id) REFERENCES TypeEnum (id)
);