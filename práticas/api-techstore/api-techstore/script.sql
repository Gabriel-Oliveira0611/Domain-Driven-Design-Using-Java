create table t_tech_produto
(
    id_produto         number(10) primary key,
    nome_produto       varchar2(50)  not null,
    quantidade_produto number(20)    not null,
    valor_produto      number(10, 2) not null
);

create sequence sq_t_tech_produto start with 1 increment by 1 nocycle;

insert into t_tech_produto (id_produto, nome_produto, quantidade_produto, valor_produto)
values (1, 'smartWatch', 50, 270);