---------------------------------------- FORMA 1 -----------------------------
WITH teams AS (select id, name
               from teams),
     matchesLocal AS (select t1.id as id, t1.name as name, count(t1.id) as vecesJugadas
                      from matches m
                               inner join teams t1 on t1.id = m.team_1
                               inner join teams t2 on t2.id = m.team_2
                      group by t1.id, t1.name),
     matchesVisitante AS (select t2.id, t2.name, count(t2.id) as vecesJugadas
                          from matches m
                                   inner join teams t1 on t1.id = m.team_1
                                   inner join teams t2 on t2.id = m.team_2
                          group by t2.id, t2.name, t2.id),
     victoriasLocal AS (select t1.id,
                               t1.name,
                               (SUM(CASE WHEN m.team_1_goals > m.team_2_goals THEN 1 ELSE 0 END)) as victoriasLocal
                        from matches m
                                 inner join teams t1 on t1.id = m.team_1
                                 inner join teams t2 on t2.id = m.team_2
                        group by t1.id, t1.name, t1.id),
     victoriasVisitante AS (select t2.id,
                                   t2.name,
                                   (SUM(CASE WHEN m.team_2_goals > m.team_1_goals THEN 1 ELSE 0 END)) as victoriasVisitante
                            from matches m
                                     inner join teams t1 on t1.id = m.team_1
                                     inner join teams t2 on t2.id = m.team_2
                            group by t2.id, t2.name, t2.id),
     derrotasLocal AS (select t1.id,
                              t1.name,
                              (SUM(CASE WHEN m.team_1_goals < m.team_2_goals THEN 1 ELSE 0 END)) as derrotasLocal
                       from matches m
                                inner join teams t1 on t1.id = m.team_1
                                inner join teams t2 on t2.id = m.team_2
                       group by t1.id, t1.name, t1.id),
     derrotasVisitante AS (select t2.id,
                                  t2.name,
                                  (SUM(CASE WHEN m.team_2_goals < m.team_1_goals THEN 1 ELSE 0 END)) as derrotasVisitante
                           from matches m
                                    inner join teams t1 on t1.id = m.team_1
                                    inner join teams t2 on t2.id = m.team_2
                           group by t2.id, t2.name, t2.id),
     empatesLocal AS (select t1.id,
                             t1.name,
                             (SUM(CASE WHEN m.team_1_goals = m.team_2_goals THEN 1 ELSE 0 END)) as empatesLocal
                      from matches m
                               inner join teams t1 on t1.id = m.team_1
                               inner join teams t2 on t2.id = m.team_2
                      group by t1.id, t1.name, t1.id),
     empatesVisitante AS (select t2.id,
                                 t2.name,
                                 (SUM(CASE WHEN m.team_2_goals = m.team_1_goals THEN 1 ELSE 0 END)) as empatesVisitante
                          from matches m
                                   inner join teams t1 on t1.id = m.team_1
                                   inner join teams t2 on t2.id = m.team_2
                          group by t2.id, t2.name, t2.id),
     scoreLocal AS (select t1.id,
                           t1.name,
                           (SUM(CASE
                                    WHEN m.team_1_goals > m.team_2_goals THEN 3
                                    ELSE
                                        CASE WHEN m.team_1_goals = m.team_2_goals THEN 1 ELSE 0 END
                               END))
                               as scoreLocal
                    from matches m
                             inner join teams t1 on t1.id = m.team_1
                             inner join teams t2 on t2.id = m.team_2
                    group by t1.id, t1.name, t1.id),
     scoreVisitante AS (select t2.id,
                               t2.name,
                               (SUM(CASE
                                        WHEN m.team_2_goals > m.team_1_goals THEN 3
                                        ELSE
                                            CASE WHEN m.team_2_goals = m.team_1_goals THEN 1 ELSE 0 END
                                   END))
                                   as scoreVisitante
                        from matches m
                                 inner join teams t1 on t1.id = m.team_1
                                 inner join teams t2 on t2.id = m.team_2
                        group by t2.id, t2.name, t2.id)
SELECT ml.name,
       (ml.vecesJugadas + mv.vecesJugadas)         as matches,
       (vl.victoriasLocal + vv.victoriasVisitante) as victories,
       (dl.derrotasLocal + dv.derrotasVisitante)   as defeats,
       (el.empatesLocal + ev.empatesVisitante)     as draws,
       (sl.scoreLocal + sv.scoreVisitante)         as score
FROM matchesLocal ml
         inner join matchesVisitante mv
                    on ml.id = mv.id
         inner join victoriasLocal vl
                    on vl.id = ml.id
         inner join victoriasVisitante vv
                    on vv.id = ml.id
         inner join derrotasLocal dl
                    on dl.id = ml.id
         inner join derrotasVisitante dv
                    on dv.id = ml.id
         inner join empatesLocal el
                    on el.id = ml.id
         inner join empatesVisitante ev
                    on ev.id = ml.id
         inner join scoreVisitante sv
                    on sv.id = ml.id
         inner join scoreLocal sl
                    on sl.id = ml.id
         order by score desc, ml.id asc

---------------------------------------- FORMA 2 -----------------------------
SELECT name, -- Nombre del equipo
    (
        -- Matches local
        (SELECT count(*) from matches m where team.id = team_1)
        +
        -- Matches visitante
        (SELECT count(*) from matches m where team.id = team_2)
    ) AS matches,
    (
        -- Victorias local
        (SELECT count(*) from matches m where team.id = team_1 AND m.team_1_goals > m.team_2_goals)
        +
        -- Victorias visitante
        (SELECT count(*) from matches m where team.id = team_2 AND m.team_2_goals > m.team_1_goals)
    ) AS victories,
    (
        -- Derrotas local
        (SELECT count(*) from matches m where team.id = team_1 AND m.team_1_goals < m.team_2_goals)
        +
        -- Derrotas visitante
        (SELECT count(*) from matches m where team.id = team_2 AND m.team_2_goals < m.team_1_goals)
    ) AS defeats,
    (
        -- Derrotas local
        (SELECT count(*) from matches m where team.id = team_1 AND m.team_1_goals = m.team_2_goals)
        +
        -- Derrotas visitante
        (SELECT count(*) from matches m where team.id = team_2 AND m.team_2_goals = m.team_1_goals)
    ) AS draws,
    (
        -- Score local
        (SELECT SUM(CASE WHEN m.team_1_goals > m.team_2_goals THEN 3 ELSE CASE WHEN m.team_1_goals = m.team_2_goals THEN 1 ELSE 0 END END) from matches m where team.id = team_1)
        +
        -- Score visitante
        (SELECT SUM(CASE WHEN m.team_2_goals > m.team_1_goals THEN 3 ELSE CASE WHEN m.team_2_goals = m.team_1_goals THEN 1 ELSE 0 END END) from matches m where team.id = team_2)
    ) AS score
FROM teams AS team
ORDER BY score DESC;
