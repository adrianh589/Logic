
-- Solucion
WITH salariosDeptos AS (
    SELECT dep.cod_dep,
        (coalesce(SUM(venc.valor), 0)
                      -
        (select SUM(coalesce(des.valor, 0))
         from empregado as empl
                  left join emp_desc
                            on emp_desc.matr = empl.matr
                  left join desconto as des
                            on des.cod_desc = emp_desc.cod_desc
         where empl.matr = emp.matr)
           ) as salario
           from empregado as emp
            left join emp_venc
                        on emp_venc.matr = emp.matr
            left join vencimento as venc
                        on venc.cod_venc = emp_venc.cod_venc
           left join departamento as dep
           on dep.cod_dep = emp.lotacao
           group by dep.cod_dep, emp.matr
)
    SELECT dep.nome                          as "Nome Departamento", -- Nombre del departamento
       (SELECT count(1)
        from empregado as emp
                 inner join divisao as div
                            on emp.lotacao_div = div.cod_divisao
        where dep.cod_dep = div.cod_dep) as "Numero de Empregados" -- Numero de empleados
        ,
       ( round(avg(salDep.salario), 2) )                                 as "Media Salarial", -- Media salarial
       ( round(max(salDep.salario), 2) )                                 as "Maior Salario", -- Mayor salario
       ( round(min(salDep.salario), 2) )                                 as "Menor Salario" -- Menor salario
FROM departamento as dep
inner join salariosDeptos as salDep
on salDep.cod_dep = dep.cod_dep
group by dep.nome, dep.cod_dep
order by "Media Salarial" desc;

-- Zona de pruebas para saber los salarios restando los descuentos
SELECT emp.matr as empleado_matricula,
       emp.nome as empleado_nombre,
       (SUM(venc.valor)
           -
        (select SUM(coalesce(des.valor, 0))
         from empregado as empl
                  left join emp_desc
                            on emp_desc.matr = empl.matr
                  left join desconto as des
                            on des.cod_desc = emp_desc.cod_desc
         where empl.matr = emp.matr)
           )    as salario_total
from empregado as emp
         left join emp_venc
                   on emp_venc.matr = emp.matr
         left join vencimento as venc
                   on venc.cod_venc = emp_venc.cod_venc
group by emp.matr, emp.nome;

-- Zona de pruebas con descuentos
SELECT *
FROM empregado AS emp
         LEFT JOIN emp_venc ON emp_venc.matr = emp.matr
         LEFT JOIN vencimento AS venc ON venc.cod_venc = emp_venc.cod_venc
         LEFT JOIN divisao as div
                   on div.cod_divisao = emp.lotacao_div
         left join departamento as dep
                   on dep.cod_dep = div.cod_dep;

-- Descuentos por empleados
select SUM(des.valor)
from empregado as emp
         left join emp_desc
                   on emp_desc.matr = emp.matr
         left join desconto as des
                   on des.cod_desc = emp_desc.cod_desc
where emp.matr = 27;

-- Para arreglar
SELECT dep.nome ,
        (coalesce(SUM(venc.valor), 0)
                      -
        (select SUM(coalesce(des.valor, 0))
         from empregado as empl
                  left join emp_desc
                            on emp_desc.matr = empl.matr
                  left join desconto as des
                            on des.cod_desc = emp_desc.cod_desc
         where empl.matr = emp.matr)
           ) as salario
           from empregado as emp
            left join emp_venc
                        on emp_venc.matr = emp.matr
            left join vencimento as venc
                        on venc.cod_venc = emp_venc.cod_venc
           left join departamento as dep
           on dep.cod_dep = emp.lotacao
           group by dep.nome, emp.matr
            order by dep.nome, salario desc
