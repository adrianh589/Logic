WITH RankedUsers AS (
    SELECT
        CASE WHEN u1.posts < u2.posts THEN u1.user_id ELSE u2.user_id END AS id,
        CASE WHEN u1.posts < u2.posts THEN u1.user_name ELSE u2.user_name END AS seguidor,
        CASE WHEN u2.posts > u1.posts THEN u2.user_name ELSE u1.user_name END AS seguido
    FROM followers AS f1
    INNER JOIN followers AS f2
        ON f1.user_id_fk = f2.following_user_id_fk AND f1.following_user_id_fk = f2.user_id_fk
    INNER JOIN users AS u1
        ON f1.user_id_fk = u1.user_id
    INNER JOIN users AS u2
        ON f2.user_id_fk = u2.user_id
    WHERE f1.user_id_fk < f2.user_id_fk
)
SELECT seguidor, seguido
FROM RankedUsers
ORDER BY 1; -- Ordena por la primera columna en la subconsulta (id)
