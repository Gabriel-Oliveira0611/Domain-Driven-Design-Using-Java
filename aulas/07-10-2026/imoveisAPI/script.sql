create table t_api_imovel
(
    cd_imovel   number(9, 0) primary key,
    ds_imovel   varchar(255) not null,
    nr_dimensao number(9, 2),
    vl_imovel   number(9, 2) not null
);

create sequence sq_t_api_imovel start with 1 increment by 1 nocache;

create table t_api_tipo_imovel
(
    cd_tipo     number(9, 0) primary key,
    nm_tipo     varchar(60) not null,
    dt_cadastro date
);

create sequence sq_t_api_tipo_imovel start with 1 increment by 1 nocache;

alter table t_api_imovel
    add cd_tipo number(9, 0);

alter table t_api_imovel
    add CONSTRAINT fk_api_tipo FOREIGN key (cd_tipo) references t_api_tipo_imovel (cd_tipo);

insert into t_api_imovel
(cd_imovel,
 ds_imovel,
 nr_dimensao,
 vl_imovel,
 t_api_imovel.cd_tipo)
values (sq_t_api_imovel.nextval, ?, ?, ?, ?);
select *
from t_api_imovel;
select *
from t_api_imovel
where cd_imovel = ?;
update t_api_imovel
set ds_imovel   = ?,
    nr_dimensao = ?,
    vl_imovel   = ?,
    cd_tipo     = ?
where cd_imovel = ?;
delete
from t_api_imovel
where cd_imovel = ?;

-- Comandos TipoImovel

insert into t_api_tipo_imovel (cd_tipo, nm_tipo, dt_cadastro)
values (sq_t_api_tipo_imovel.nextval, ?, ?);
select *
from t_api_tipo_imovel;
update t_api_tipo_imovel
set nm_tipo     = ?,
    dt_cadastro = ?
where cd_tipo = ?;
delete
from t_api_tipo_imovel
where cd_tipo = ?;

-- Select com inner join

select cd_imovel,
       ds_imovel,
       nr_dimensao,
       vl_imovel,
       t_api_tipo_imovel.cd_tipo,
       nm_tipo,
       dt_cadastro
from t_api_imovel
         inner join t_api_tipo_imovel on t_api_tipo_imovel.cd_tipo = t_api_imovel.cd_tipo
where cd_imovel = ?;