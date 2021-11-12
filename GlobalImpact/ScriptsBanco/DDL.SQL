/*
Andrey Fernandez Garcia - RM: 87219
Diego Augusto da Cruz - RM 86877
Emily Keyt Manfrin - RM: 87198
Giovana Nelo Furlan - RM: 88936
Joao Victor de Jesus Martins Silva - RM: 89087
*/

CREATE TABLE t_doacao_venda (
    cd_doacao_venda  NUMBER(9) NOT NULL,
    cd_produto       NUMBER(9) NOT NULL,
    cd_supermercado  NUMBER(9) NOT NULL
);

ALTER TABLE t_doacao_venda ADD CONSTRAINT t_doacao_venda_pk PRIMARY KEY ( cd_doacao_venda );

CREATE TABLE t_endereco (
    cd_endereco          NUMBER(9) NOT NULL,
    cd_supermercado      NUMBER(9) NOT NULL,
    nr_cep               VARCHAR2(10) NOT NULL,
    nm_logradouro        VARCHAR2(170) NOT NULL,
    nr_logradouro        NUMBER(5) NOT NULL,
    ds_complemento       VARCHAR2(20),
    nm_bairro            VARCHAR2(50) NOT NULL,
    nm_cidade            VARCHAR2(50) NOT NULL,
    nm_estado            VARCHAR2(50) NOT NULL,
    sg_estado            CHAR(2),
    ds_ponto_referencia  VARCHAR2(90)
);

ALTER TABLE t_endereco ADD CONSTRAINT t_endereco_pk PRIMARY KEY ( cd_endereco );

CREATE TABLE t_produto (
    cd_produto    NUMBER(9) NOT NULL,
    cd_barras     NUMBER(11),
    nm_produto    VARCHAR2(70) NOT NULL,
    ds_embalagem  VARCHAR2(30),
    qt_estoque    NUMBER(9, 2) NOT NULL,
    dt_cadastro   DATE NOT NULL,
    dt_validade   DATE NOT NULL,
    vl_unitario   NUMBER(9, 2) NOT NULL,
    vl_total      NUMBER(9, 2) NOT NULL,
    ds_promocao   VARCHAR2(70)
);

ALTER TABLE t_produto ADD CONSTRAINT t_produto_pk PRIMARY KEY ( cd_produto );

CREATE TABLE t_supermercados (
    cd_supermercado        NUMBER(9) NOT NULL,
    nm_supermercado        VARCHAR2(90) NOT NULL,
    st_ativo               VARCHAR2(8) NOT NULL,
    dt_cadastro            DATE NOT NULL,
    nr_cnpj                VARCHAR2(14) NOT NULL,
    nr_inscricao_estadual  VARCHAR2(12),
    dt_fundacao            DATE,
    ds_email               VARCHAR2(35) NOT NULL,
    ds_senha               VARCHAR2(20) NOT NULL
);

ALTER TABLE t_supermercados
    ADD CONSTRAINT "T_SUPER(st_ativo)_CK" CHECK ( st_ativo IN ( 'ATIVO','INATIVO' ) );

ALTER TABLE t_supermercados ADD CONSTRAINT t_supermercados_pk PRIMARY KEY ( cd_supermercado );

ALTER TABLE t_supermercados ADD CONSTRAINT t_super_un UNIQUE ( nr_cnpj );

CREATE TABLE t_telefone (
    cd_telefone      NUMBER(9) NOT NULL,
    cd_supermercado  NUMBER(9) NOT NULL,
    cd_ddi           VARCHAR2(3) NOT NULL,
    cd_ddd           NUMBER(3) NOT NULL,
    nr_telefone      NUMBER(15) NOT NULL,
    tp_telefone      VARCHAR2(20)
);

ALTER TABLE t_telefone ADD CONSTRAINT t_telefone_pk PRIMARY KEY ( cd_telefone );

ALTER TABLE t_doacao_venda
    ADD CONSTRAINT t_doa_vend_prod_fk FOREIGN KEY ( cd_produto )
        REFERENCES t_produto ( cd_produto );

ALTER TABLE t_doacao_venda
    ADD CONSTRAINT t_doa_vend_super_fk FOREIGN KEY ( cd_supermercado )
        REFERENCES t_supermercados ( cd_supermercado );

ALTER TABLE t_endereco
    ADD CONSTRAINT t_end_t_super_fk FOREIGN KEY ( cd_supermercado )
        REFERENCES t_supermercados ( cd_supermercado );

ALTER TABLE t_telefone
    ADD CONSTRAINT t_tel_super_fk FOREIGN KEY ( cd_supermercado )
        REFERENCES t_supermercados ( cd_supermercado );


CREATE SEQUENCE SQ_T_SUPERMERCADO
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_T_TELEFONE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_T_ENDERECO
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_T_DOACAO_VENDA
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_T_PRODUTO
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE
NOCYCLE;

