/*

Andrey Fernandez Garcia - RM: 87219
Diego Augusto da Cruz - RM 86877
Emily Keyt Manfrin - RM: 87198
Giovana Nelo Furlan - RM: 88936
João Victor de Jesus Martins Silva - RM: 89087
Pedro Henrique Santos Modesto Delmondes - RM: 86719

*/


DROP TABLE endorf_end CASCADE CONSTRAINTS;

CREATE TABLE endorf_end (
    id_end           NUMBER(10) NOT NULL,
    nm_rua           VARCHAR2(80),
    nr_numero        NUMBER(5),
    nr_cep           NUMBER(7),
    nm_bairro        VARCHAR2(40),
    nm_cidade        VARCHAR2(40) NOT NULL,
    nm_estado        VARCHAR2(40) NOT NULL,
    id_usuario       NUMBER(10) NULL,
    id_profissional  NUMBER(10) NULL
);

ALTER TABLE endorf_end ADD CONSTRAINT pk_endorf_end PRIMARY KEY ( id_end );

CREATE SEQUENCE sq_endorf_end
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;


DROP TABLE endorf_hobby CASCADE CONSTRAINTS;

CREATE TABLE endorf_hobby (
    id_hobby  NUMBER(10) NOT NULL,
    nm_hobby  VARCHAR2(40) NOT NULL
);

ALTER TABLE endorf_hobby ADD CONSTRAINT pk_endorf_hobby PRIMARY KEY ( id_hobby );

CREATE SEQUENCE sq_endorf_hobby
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;


DROP TABLE endorf_hobby_profi CASCADE CONSTRAINTS;

CREATE TABLE endorf_hobby_profi (
    id_hobby         NUMBER(10) NOT NULL,
    id_profissional  NUMBER(10) NOT NULL
);

ALTER TABLE endorf_hobby_profi ADD CONSTRAINT pk_endorf_hobby_profi PRIMARY KEY ( id_hobby,id_profissional );

CREATE SEQUENCE sq_endorf_hobby_profi
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;
                                                                                                                
      
DROP TABLE endorf_hobby_usuario CASCADE CONSTRAINTS;

CREATE TABLE endorf_hobby_usuario (
    id_hobby    NUMBER(10) NOT NULL,
    id_usuario  NUMBER(10) NOT NULL
);

ALTER TABLE endorf_hobby_usuario ADD CONSTRAINT pk_endorf_hobby_usuario PRIMARY KEY ( id_hobby,id_usuario );

CREATE SEQUENCE sq_endorf_hobby_usuario
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;
                                                                    
                                                                                              
DROP TABLE endorf_profi CASCADE CONSTRAINTS;

CREATE TABLE endorf_profi (
    id_profissional  NUMBER(10) NOT NULL,
    nm_profissional  VARCHAR2(80) NOT NULL,
    dt_nascimento    DATE NOT NULL,
    ft_foto          BLOB,
    dt_cadastro      DATE NOT NULL,
    ds_email         VARCHAR2(50) NOT NULL, 
    ds_senha         VARCHAR2(20) NOT NULL
);

ALTER TABLE endorf_profi ADD CONSTRAINT pk_endorf_profi PRIMARY KEY ( id_profissional );

CREATE SEQUENCE sq_endorf_profi
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;


DROP TABLE endorf_tel CASCADE CONSTRAINTS;

CREATE TABLE endorf_tel (
    id_tel           NUMBER(10) NOT NULL,
    id_usuario       NUMBER(10),
    id_profissional  NUMBER(10),
    nr_numero        NUMBER(9) NOT NULL,
    nr_ddd           NUMBER(3) NOT NULL,
    nr_ddi           NUMBER(3) NOT NULL
);
ALTER TABLE endorf_tel ADD CONSTRAINT pk_endorf_tel PRIMARY KEY ( id_tel );

CREATE SEQUENCE sq_endorf_tel
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;

DROP TABLE endorf_usuario CASCADE CONSTRAINTS;

CREATE TABLE endorf_usuario (
    id_usuario     NUMBER(10) NOT NULL,
    nm_usuario     VARCHAR2(80) NOT NULL,
    dt_nascimento  DATE NOT NULL,
    ft_foto        BLOB,
    dt_cadastro    DATE NOT NULL,
    ds_email       VARCHAR2(50) NOT NULL, 
    ds_senha       VARCHAR2(20) NOT NULL
);

ALTER TABLE endorf_usuario ADD CONSTRAINT pk_endorf_usuario PRIMARY KEY ( id_usuario );

CREATE SEQUENCE sq_endorf_usuario
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;


DROP TABLE endorf_usuario_profi CASCADE CONSTRAINTS;

CREATE TABLE endorf_usuario_profi (
    id_usuario       NUMBER(10) NOT NULL,
    id_profissional  NUMBER(10) NOT NULL
);

ALTER TABLE endorf_usuario_profi ADD CONSTRAINT pk_endorf_usuario_profi PRIMARY KEY ( id_usuario,id_profissional );

CREATE SEQUENCE sq_endorf_usuario_profi
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;
                                                                                    

DROP TABLE endorf_video CASCADE CONSTRAINTS;

CREATE TABLE endorf_video (
    id_video          NUMBER(10) NOT NULL,
    id_profissional   NUMBER(10) NOT NULL,
    vd_video          BLOB,
    dt_postagem       DATE NOT NULL,
    nr_visualizacoes  NUMBER(10) NOT NULL,
    nr_duracao        NUMBER(10) NOT NULL
);

ALTER TABLE endorf_video ADD CONSTRAINT pk_endorf_video PRIMARY KEY ( id_video );

CREATE SEQUENCE sq_endorf_video
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE  
NOCACHE 
NOCYCLE;


ALTER TABLE endorf_end
    ADD CONSTRAINT fk_end_profi FOREIGN KEY ( id_profissional )
        REFERENCES endorf_profi ( id_profissional );

ALTER TABLE endorf_end
    ADD CONSTRAINT fk_end_usuario FOREIGN KEY ( id_usuario )
        REFERENCES endorf_usuario ( id_usuario );

ALTER TABLE endorf_hobby_profi
    ADD CONSTRAINT fk_hobby_profi FOREIGN KEY ( id_hobby )
        REFERENCES endorf_hobby ( id_hobby );

ALTER TABLE endorf_hobby_usuario
    ADD CONSTRAINT fk_hobby_usuario FOREIGN KEY ( id_hobby )
        REFERENCES endorf_hobby ( id_hobby );

ALTER TABLE endorf_hobby_profi
    ADD CONSTRAINT fk_profi_hobby FOREIGN KEY ( id_profissional )
        REFERENCES endorf_profi ( id_profissional );

ALTER TABLE endorf_tel
    ADD CONSTRAINT fk_profi_tel FOREIGN KEY ( id_profissional )
        REFERENCES endorf_profi ( id_profissional );

ALTER TABLE endorf_usuario_profi
    ADD CONSTRAINT fk_profi_usuario FOREIGN KEY ( id_profissional )
        REFERENCES endorf_profi ( id_profissional );

ALTER TABLE endorf_hobby_usuario
    ADD CONSTRAINT fk_usuario_hobby FOREIGN KEY ( id_usuario )
        REFERENCES endorf_usuario ( id_usuario );

ALTER TABLE endorf_usuario_profi
    ADD CONSTRAINT fk_usuario_profi FOREIGN KEY ( id_usuario )
        REFERENCES endorf_usuario ( id_usuario );

ALTER TABLE endorf_tel
    ADD CONSTRAINT fk_usuario_tel FOREIGN KEY ( id_usuario )
        REFERENCES endorf_usuario ( id_usuario );

ALTER TABLE endorf_video
    ADD CONSTRAINT fk_video_profi FOREIGN KEY ( id_profissional )
        REFERENCES endorf_profi ( id_profissional );
