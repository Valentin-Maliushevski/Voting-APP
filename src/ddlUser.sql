CREATE DATABASE vote
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;


CREATE SCHEMA users
    AUTHORIZATION postgres;

CREATE TABLE users.t_user
(
    uuid uuid,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    identification_number character varying(10),
    user_status character varying,
    passport_number character varying,
    account_non_expired boolean,
    account_non_locked boolean,
    credentials_non_expired boolean,
    enabled boolean,
    PRIMARY KEY (uuid),
    CONSTRAINT identification_number UNIQUE (identification_number),
    CONSTRAINT passport_number UNIQUE (passport_number)
);

ALTER TABLE IF EXISTS users.t_user
    OWNER to postgres;

CREATE TABLE users.t_role
(
    id bigint,
    name character varying
);

ALTER TABLE IF EXISTS users.t_role
    OWNER to postgres;

CREATE TABLE users.t_user_roles
(
    user_uuid uuid,
    role_id integer
);

ALTER TABLE IF EXISTS users.t_user_roles
    OWNER to postgres;




