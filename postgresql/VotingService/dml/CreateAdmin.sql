\connect vote_db

INSERT INTO voices.t_role(id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO voices.t_user (uuid, dt_create, dt_update, identification_number, user_status,
passport_number, account_non_expired,account_non_locked, credentials_non_expired, enabled)
VALUES (gen_random_uuid (), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
'0123456789', 'ACTIVATED', '$2a$10$Ezpw9ZhPcfhIBaRW1HQ36.lvJwOASR1bpw3uPH7vxGWe45rgpZSVy','true', 'true', 'true', 'true');

INSERT INTO voices.t_user_roles (user_uuid, role_id)
VALUES((SELECT uuid  FROM users.t_user WHERE identification_number = '0123456789'), 2);
