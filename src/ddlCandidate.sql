CREATE SCHEMA candidates
    AUTHORIZATION postgres;

CREATE TABLE candidates.candidate
(
    uuid uuid,
    title character varying,
    description text,
    status character varying,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone
);

ALTER TABLE IF EXISTS candidates.candidate
    OWNER to postgres;
