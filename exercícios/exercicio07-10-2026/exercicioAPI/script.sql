insert into T_API_IMOVEL (CD_IMOVEL, DS_IMOVEL, NR_DIMENSAO, VL_IMOVEL, CD_TIPO)
values (SQ_T_API_IMOVEL.nextval, ?, ?, ?, ?);

select CD_IMOVEL,
       DS_IMOVEL,
       NR_DIMENSAO,
       VL_IMOVEL,
       T_API_IMOVEL.CD_TIPO,
       NM_TIPO,
       T_API_TIPO_IMOVEL.CD_TIPO
from T_API_IMOVEL
         inner join T_API_TIPO_IMOVEL on (T_API_TIPO_IMOVEL.CD_TIPO = T_API_IMOVEL.CD_TIPO);

select CD_IMOVEL,
       DS_IMOVEL,
       NR_DIMENSAO,
       VL_IMOVEL,
       T_API_IMOVEL.CD_TIPO,
       NM_TIPO,
       T_API_TIPO_IMOVEL.CD_TIPO
from T_API_IMOVEL
         inner join T_API_TIPO_IMOVEL on (T_API_TIPO_IMOVEL.CD_TIPO = T_API_IMOVEL.CD_TIPO)
where CD_IMOVEL = ?;

update T_API_IMOVEL
set DS_IMOVEL   = ?,
    NR_DIMENSAO = ?,
    VL_IMOVEL   = ?,
    CD_TIPO     = ?
where CD_IMOVEL = ?;

delete
from T_API_IMOVEL
where CD_IMOVEL = ?;

insert into T_API_TIPO_IMOVEL (CD_TIPO, NM_TIPO, DT_CADASTRO)
values (SQ_T_API_TIPO_IMOVEL.nextval, ?, ?);

select CD_TIPO,
       NM_TIPO,
       DT_CADASTRO
from T_API_TIPO_IMOVEL;

select CD_TIPO,
       NM_TIPO,
       DT_CADASTRO
from T_API_TIPO_IMOVEL WHERE CD_TIPO = ?;

update T_API_TIPO_IMOVEL
set NM_TIPO = ?,
    DT_CADASTRO = ?
where CD_TIPO = ?;

delete
from T_API_TIPO_IMOVEL
where CD_TIPO = ?;
