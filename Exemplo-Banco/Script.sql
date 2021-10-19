CREATE TABLE t_produto (
    cd_produto     NUMBER PRIMARY KEY,
    nm_produto     VARCHAR(80) NOT NULL,
    ds_produto     VARCHAR(255),
    vl_produto     FLOAT NOT NULL,
    nm_fornecedor  VARCHAR(80)
);

CREATE SEQUENCE sq_t_produto START WITH 1 INCREMENT BY 1 NOCACHE;

CREATE TABLE t_categoria (
    cd_categoria  NUMBER NOT NULL PRIMARY KEY,
    nm_categoria  VARCHAR(40) NOT NULL,
    dt_cadastro   DATE
);

CREATE SEQUENCE sq_t_categoria START WITH 1 INCREMENT BY 1 NOCACHE;

CREATE TABLE t_nota_fiscal (
    cd_nota  NUMBER NOT NULL PRIMARY KEY,
    vl_nota  NUMBER
);

CREATE SEQUENCE sq_t_nota_fiscal START WITH 1 INCREMENT BY 1 NOCACHE;

CREATE TABLE t_pedido (
    cd_pedido  NUMBER NOT NULL PRIMARY KEY,
    dt_pedido  DATE,
    cd_nota    NUMBER NOT NULL,
    CONSTRAINT fk_cd_nota_fiscal FOREIGN KEY ( cd_nota )
        REFERENCES t_nota_fiscal ( cd_nota )
);

CREATE SEQUENCE sq_t_pedido START WITH 1 INCREMENT BY 1 NOCACHE;

CREATE TABLE t_item_pedido (
    cd_produto  NUMBER NOT NULL,
    cd_pedido   NUMBER NOT NULL,
    CONSTRAINT pk_item_pedido PRIMARY KEY ( cd_produto,
                                            cd_pedido ),
    CONSTRAINT fk_cd_produto_t_produto FOREIGN KEY ( cd_produto )
        REFERENCES t_produto ( cd_produto ),
    CONSTRAINT fk_cd_pedido_t_pedido FOREIGN KEY ( cd_pedido )
        REFERENCES t_pedido ( cd_pedido )
);

ALTER TABLE t_produto ADD cd_categoria NUMBER;

ALTER TABLE t_produto
    ADD CONSTRAINT fk_cd_categoria_t_categoria FOREIGN KEY ( cd_categoria )
        REFERENCES t_categoria ( cd_categoria );