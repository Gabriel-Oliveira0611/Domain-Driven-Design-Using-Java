create table t_api_motopecas (
    id_produto number(10) primary key,
    nome_produto varchar2(100) not null,
    quantidade_produto number(10) default 0,
    valor_produto number(10,2) not null,
    fornecedor_produto varchar2(100)
);

create sequence sq_t_api_motopecas start with 1 increment by 1 nocycle;

