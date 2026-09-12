create table t_jdbc_categoria
(
    cd_categoria number(9, 0) primary key,
    nm_categoria varchar2(50) not null
);

create sequence sq_t_jdbc_categoria start with 1 increment by 1 nocache;

