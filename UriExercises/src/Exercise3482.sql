SELECT
        CASE WHEN u1.posts < u2.posts THEN u1.user_id ELSE u2.user_id END AS id,
        CASE WHEN u1.posts < u2.posts THEN u1.user_name ELSE u2.user_name END AS seguidor,
        CASE WHEN u2.posts > u1.posts THEN u2.user_name ELSE u1.user_name END AS seguido
    FROM followers as f1
        inner join followers f2
            on f1.user_id_fk = f2.following_user_id_fk and f1.following_user_id_fk = f2.user_id_fk
        inner join users as u1
        on f1.user_id_fk = u1.user_id
    inner join users as u2
        on f2.user_id_fk = u2.user_id
    where f1.user_id_fk < f2.user_id_fk
    order by id;
