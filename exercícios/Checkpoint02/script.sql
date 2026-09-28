create table t_bukan_instrutor (
    ID_INSTRUTOR number(20) primary key,
    NOME_INSTRUTOR VARCHAR2(100) not null,
    CPF_INSTRUTOR varchar2(16) not null unique,
    IDADE_INSTRUTOR number(10) not null,
    FAIXA_INSTRUTOR varchar2(100) not null,
    NIVEL_INSTRUTOR varchar2(50) not null,
    MATRICULA_INSTRUTOR DATE default sysdate
);

create sequence sq_t_bukan_instrutores start with 1 increment by 1 nocycle;