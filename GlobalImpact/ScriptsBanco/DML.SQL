/*
Andrey Fernandez Garcia - RM: 87219
Diego Augusto da Cruz - RM 86877
Emily Keyt Manfrin - RM: 87198
Giovana Nelo Furlan - RM: 88936
Joao Victor de Jesus Martins Silva - RM: 89087
*

/*supermercado*/

INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'EXTRA','ATIVO',TO_DATE('12/02/1989','DD/MM/YYYY'),'13567432897654','JOANA@GMAIL.COM','72345P');
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'DIA','ATIVO',TO_DATE('02/08/1999','DD/MM/YYYY'),'89567432897674','ANA@GMAIL.COM','92345P');   
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'POM','INATIVO',TO_DATE('22/08/1998','DD/MM/YYYY'),'79567432897674','ANABEL@GMAIL.COM','98345O'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'DOVALE','ATIVO',TO_DATE('19/11/2000','DD/MM/YYYY'),'59567432897673','AMANDA@GMAIL.COM','25345Y'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'DAVAì','INATIVO',TO_DATE('23/12/2004','DD/MM/YYYY'),'69567432897679','FELIPE@GMAIL.COM','10345P'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'SAVOY','ATIVO',TO_DATE('02/01/2007','DD/MM/YYYY'),'21567432897673','EMILIA@GMAIL.COM','27345P'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'ILHA','ATIVO',TO_DATE('29/09/2010','DD/MM/YYYY'),'13567432897674','DIEGO@GMAIL.COM','25345P'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'ASSAI','INATIVO',TO_DATE('25/04/2014','DD/MM/YYYY'),'84367432897674','MONICA@GMAIL.COM','67345P'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'ATACADAO','ATIVO',TO_DATE('02/07/2019','DD/MM/YYYY'),'4577432897674','JOAO@GMAIL.COM','91345P'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'PRINCESA','ATIVO',TO_DATE('04/05/1999','DD/MM/YYYY'),'32967432897674','ANDREY@GMAIL.COM','14345P'); 
INSERT INTO t_supermercados (cd_supermercado,nm_supermercado,st_ativo,dt_cadastro,nr_cnpj,ds_email,ds_senha) VALUES
(SQ_T_SUPERMERCADO.NEXTVAL,'BARATEIRO','ATIVO',TO_DATE('13/06/1999','DD/MM/YYYY'),'10967432897674','GIOVANA@GMAIL.COM','32345P');

COMMIT;

/*endereco*/

INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,1,03645010,'AV.DOS BANDERANTES',22,'VILA DAS CARMALIAS','SAO JOAO','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,2,03445010,'RUA CENTRAL',32,'VILA DAS CARMALIAS','MINAS GERAIS','MINAS GERAIS','MG');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,3,03745010,'AV.DOS BANDERANTES',782,'PAULISTA','SAO PAULO','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,4,03945010,'RUA OT√?',292,'VILA INDU','FLEICHERINHA','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,5,89045010,'AV.DOS PRINCESA',992,'VILA DAS BANDAS','SAO JOSAO DO PINHAL','S√ÉO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,6,56745010,'RUA PINHU',222,'VILA DO IMPERADOR','GUARAREMA','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,7,69545010,'AV.CENTRAL',98,'VILA PRAIA GRANDE','PRAIA GRANDE','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,8,78545010,'RUA MARAVILHA',92,'VILA ESPERAN√áA','UBATUBA','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,9,23145010,'AV.DOS CENTROS',9,'PRAIA GRANDE','CARAGUATATUBA','SAO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,10,0987654,'AV.DOS ANHANGUERA',23,'VILA DOS CARNEIROS','ILHA BELA','S√ÉO PAULO','SP');
INSERT INTO t_endereco (cd_endereco,cd_supermercado,nr_cep,nm_logradouro,nr_logradouro,nm_bairro,nm_cidade,nm_estado,sg_estado) VALUES
(SQ_T_ENDERECO.NEXTVAL,11,02345010,'RUA ITA',21,'VILA RA','SAO JOAO DO RIO PRETO','SAO PAULO','SP');

COMMIT;

/*telefone*/

INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,10,'+55',011,65443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,9,'+55',011,923443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,8,'+55',012,976443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,7,'+55',018,976443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,6,'+55',017,976443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,5,'+55',016,964543567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,4,'+55',015,25443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,3,'+55',014,665443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,2,'+55',013,865443567);
INSERT INTO t_telefone (cd_telefone,cd_supermercado,cd_ddi,cd_ddd,nr_telefone) VALUES
(SQ_T_TELEFONE.NEXTVAL,1,'+55',012,987443567);
COMMIT;

/*produto*/

INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'DANONE',10,TO_DATE('23/07/2021','DD/MM/YYYY'),TO_DATE('13/11/2021','DD/MM/YYYY'),13,130);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'LEITE',4,TO_DATE('13/03/2021','DD/MM/YYYY'),TO_DATE('13/12/2021','DD/MM/YYYY'),4,16);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'REQUEIJAO',3,TO_DATE('18/07/2021','DD/MM/YYYY'),TO_DATE('12/11/2021','DD/MM/YYYY'),4,12);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'MACARRAO FRECO',2,TO_DATE('12/07/2021','DD/MM/YYYY'),TO_DATE('22/11/2021','DD/MM/YYYY'),1,2);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'QUEIJO',1,TO_DATE('24/07/2021','DD/MM/YYYY'),TO_DATE('30/11/2021','DD/MM/YYYY'),3,98);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'MORTADELA',5,TO_DATE('29/07/2021','DD/MM/YYYY'),TO_DATE('29/11/2021','DD/MM/YYYY'),13,138);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'SALAME',4,TO_DATE('26/07/2021','DD/MM/YYYY'),TO_DATE('09/11/2021','DD/MM/YYYY'),9,36);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'FERMENTO',3,TO_DATE('21/07/2021','DD/MM/YYYY'),TO_DATE('07/01/2022','DD/MM/YYYY'),15,45);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'FARINHA',2,TO_DATE('17/07/2021','DD/MM/YYYY'),TO_DATE('03/02/2022','DD/MM/YYYY'),3,6);
INSERT INTO t_produto (cd_produto,nm_produto,qt_estoque,dt_cadastro,dt_validade,vl_unitario,vl_total) VALUES
(SQ_T_PRODUTO.NEXTVAL,'PASTEL',1,TO_DATE('26/07/2021','DD/MM/YYYY'),TO_DATE('24/12/2021','DD/MM/YYYY'),10,10);
 
COMMIT;

/*doacao_venda*/

INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,1,11);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,2,10);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,3,9);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,4,8);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,5,7);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,6,6);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,7,5);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,8,4);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,9,3);
INSERT INTO t_doacao_venda (cd_doacao_venda,cd_produto,cd_supermercado) VALUES
(SQ_T_DOACAO_VENDA.NEXTVAL,10,2);

COMMIT;

