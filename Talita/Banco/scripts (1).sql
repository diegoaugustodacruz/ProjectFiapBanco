create table tdss_tb_categoria (cd_categoria number not null primary key, nm_categoria varchar(40) not null, dt_cadastro date);
create sequence sq_tb_categoria start with 1 increment by 1 nocache;

create table tdss_tb_nota_fiscal (cd_nota number not null primary key, vl_nota number);
create sequence sq_tb_nota_fiscal start with 1 increment by 1 nocache;

create table tdss_tb_pedido (cd_pedido number not null primary key, dt_pedido date, cd_nota number not null,
constraint fk_cd_nota foreign key (cd_nota) references tdss_tb_nota_fiscal(cd_nota));
create sequence sq_tdss_tb_pedido start with 1 increment by 1 nocache;

create table tdss_tb_item_pedido (cd_produto number not null primary key, cd_pedido number not null, 
constraint fk_cd_produto foreign key (cd_produto) references tdss_tb_produto(cd_produto),
constraint fk_cd_pedido foreign key (cd_pedido) references tdss_tb_pedido(cd_pedido));

alter table tdss_tb_produto add cd_categoria number;
alter table tdss_tb_produto add constraint fk_cd_categoria 
foreign key (cd_categoria) references tdss_tb_categoria(cd_categoria);