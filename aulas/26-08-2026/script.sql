create table t_jdbc_categoria
(
    cd_categoria number(9, 0) primary key,
    nm_categoria varchar2(50) not null
);

create sequence sq_t_jdbc_categoria start with 1 increment by 1 nocache;

update T_SIP_FUNCIONARIO
set NM_FUNCIONARIO = 'JOAO DA SILVA DE CARVALHO',
    DT_NASCIMENTO  = TO_DATE('17/09/1990', 'DD/MM/YYYY')
where NR_MATRICULA = 12345;

commit;

update T_SIP_FUNCIONARIO
set VL_SALARIO = VL_SALARIO * 1.057
where NR_MATRICULA = 12345;

commit;

delete
from T_SIP_PROJETO
where CD_PROJETO = 2;

delete
from T_SIP_FUNCIONARIO
where NR_MATRICULA = 12345;

delete
from T_SIP_PROJETO
where CD_PROJETO = (select CD_PROJETO from T_SIP_COPY_PROJETO where T_SIP_COPY_PROJETO.NM_PROJETO = 'FIAP 01');

update T_SIP_COPY_PROJETO
set CD_PROJETO = 2
where DT_INICIO = to_date('08/09/26','DD/MM/YY');