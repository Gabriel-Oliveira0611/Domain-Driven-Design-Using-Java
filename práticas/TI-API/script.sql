create table t_tech_equipamento
(
    id_equipamento         number(3, 0) primary key,
    nome_equipamento       varchar2(20)  not null,
    categoria_equipamento  varchar2(20)  not null,
    patrimonio_equipamento varchar2(30)  not null,
    status_equipamento     varchar2(20)  not null,
    valor_equipamento      number(15, 2) not null
);

create sequence sq_t_tech_equipamento start with 1 increment by 1 nocache;

insert into t_tech_equipamento (id_equipamento, nome_equipamento, categoria_equipamento, patrimonio_equipamento,
                                status_equipamento, valor_equipamento)
values (sq_t_tech_equipamento.nextval,
        'SmartWatch QCY GT',
        'SmartWatch',
        'SMART-00125',
        'Disponível',
        285.59);

insert into t_tech_equipamento (id_equipamento, nome_equipamento, categoria_equipamento, patrimonio_equipamento,
                                status_equipamento, valor_equipamento)
values (
        sq_t_tech_equipamento.nextval,
        'Celular Xiaomi',
        'Celular',
        'CEL-00125',
        'Disponível',
        1880.55
       );

insert into t_tech_equipamento (id_equipamento, nome_equipamento, categoria_equipamento, patrimonio_equipamento,
                                status_equipamento, valor_equipamento)
values (
        sq_t_tech_equipamento.nextval,
        'notebook dell',
        'Notebook',
        'NOTE-00125',
        'Disponível',
        3800.99
       );

commit;

select *
from t_tech_equipamento;

insert into t_tech_equipamento (id_equipamento, nome_equipamento, categoria_equipamento, patrimonio_equipamento,
                                status_equipamento, valor_equipamento)
values (
        sq_t_tech_equipamento.nextval,
        'meta glasses',
        'eyewear',
        'EYE-00125',
        'Disponível',
        4950.99
       );