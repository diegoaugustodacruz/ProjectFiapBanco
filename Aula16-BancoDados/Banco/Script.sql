CREATE TABLE tdss_produto (
    cd_produto  NUMBER PRIMARY KEY,
    nm_produto  VARCHAR(80) NOT NULL,
    ds_produto  VARCHAR(255),
    vl_produto  FLOAT NOT NULL,
    nm_fornecedor VARCHAR(80));

CREATE SEQUENCE sq_tb_produto START WITH 1 INCREMENT BY 1;