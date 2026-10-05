create table t_api_imovel
(
    cd_imovel   number(9) primary key,
    ds_imovel   varchar(255)  not null,
    nr_dimensao number(9, 2),
    vl_imovel   number(20, 2) not null
);

create table t_api_tipo_imovel
(
    cd_tipo       number(9, 0) primary key,
    nome_tipo     varchar2(60) not null,
    data_cadastro date
);

create sequence sq_t_api_tipo_imovel start with 1 increment by 1 nocache;

alter table T_API_IMOVEL
    add cd_tipo number(9, 0);

alter table T_API_IMOVEL
    add constraint fk_api_tipo foreign key (cd_tipo) references t_api_tipo_imovel (CD_TIPO);

insert into t_api_tipo_imovel (cd_tipo, nome_tipo, data_cadastro) values (sq_t_api_tipo_imovel.nextval, ?, ?)