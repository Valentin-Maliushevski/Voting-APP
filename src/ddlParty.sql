

CREATE TABLE voices.t_party
(
    uuid uuid,
    title character varying,
    description text,
    status character varying,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    PRIMARY KEY (uuid),
    CONSTRAINT titleParty UNIQUE (title)
);

ALTER TABLE IF EXISTS voices.t_party
    OWNER to postgres;