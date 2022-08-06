
CREATE TABLE voices.t_candidate
(
    uuid uuid,
    title character varying,
    description text,
    status character varying,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    PRIMARY KEY (uuid),
    CONSTRAINT title UNIQUE (title)
);

ALTER TABLE IF EXISTS voices.t_candidate
    OWNER to postgres;
