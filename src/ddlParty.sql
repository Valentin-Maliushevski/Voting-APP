CREATE SCHEMA parties
    AUTHORIZATION postgres;

CREATE TABLE parties.party
(
    uuid uuid,
    title character varying,
    description text,
    status character varying,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone
);

ALTER TABLE IF EXISTS parties.party
    OWNER to postgres;