create table t_hxf_compactador (
    id_compactador number(10,0) primary key,
    nome_equipamento varchar2(100) not null,
    peso_equipamento number(20,2) not null,
    valor_equipamento number(20,2) not null,
    base_equipamento number(20) not null
);

create sequence sq_t_hxf_compactador start with 1 increment by 1 nocache;

select * from t_hxf_compactador;
select * from t_hxf_compactador where id_compactador = ?;
update t_hxf_compactador set nome_equipamento = ?, peso_equipamento = ?, valor_equipamento = ?, base_equipamento = ? where id_compactador = ?;
delete from t_hxf_compactador where id_compactador = ?;
insert into t_hxf_compactador (id_compactador, nome_equipamento, peso_equipamento, valor_equipamento, base_equipamento) values (sq_t_hxf_compactador.nextval, ?, ?, ?, ?);

alter table t_hxf_compactador rename column nome_equipamento to nome_compactador;
alter table t_hxf_compactador rename column peso_equipamento to peso_compactador;
alter table t_hxf_compactador rename column valor_equipamento to valor_compactador;
alter table t_hxf_compactador rename column base_equipamento to base_compactador;