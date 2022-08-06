CREATE SCHEMA voices
    AUTHORIZATION postgres;

CREATE TABLE voices.t_voice
(
    uuid uuid,
    user_uuid uuid,
    candidate_uuid uuid,
    party_uuid uuid,
    dt_create timestamp without time zone,
    PRIMARY KEY (uuid)
);

ALTER TABLE IF EXISTS voices.t_voice
    OWNER to postgres;