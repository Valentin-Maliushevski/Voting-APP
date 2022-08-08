SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE DATABASE vote_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';

\connect vote_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE SCHEMA voices;

SET default_tablespace = '';
SET default_table_access_method = heap;

CREATE TABLE voices.t_user
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
    enabled boolean
);

ALTER TABLE ONLY voices.t_user
    ADD CONSTRAINT user_pkey PRIMARY KEY (uuid);

ALTER TABLE ONLY voices.t_user
    ADD CONSTRAINT unique_identification_number_key UNIQUE (identification_number);

ALTER TABLE ONLY voices.t_user
    ADD CONSTRAINT unique_passport_number_key UNIQUE (passport_number);


CREATE TABLE voices.t_role
(
    id bigint,
    name character varying
);

ALTER TABLE ONLY voices.t_role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


CREATE TABLE voices.t_user_roles
(
    user_uuid uuid,
    role_id integer
);

ALTER TABLE ONLY voices.t_user_roles
    ADD CONSTRAINT role FOREIGN KEY (role_id) REFERENCES voices.t_role(id);

CREATE TABLE voices.t_candidate
(
    uuid uuid,
    title character varying,
    description text,
    status character varying,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone
);

ALTER TABLE ONLY voices.t_candidate
    ADD CONSTRAINT candidate_pkey PRIMARY KEY (uuid);

ALTER TABLE ONLY voices.t_candidate
    ADD CONSTRAINT unique_title_key UNIQUE (title);

CREATE TABLE voices.t_party
(
    uuid uuid,
    title character varying,
    description text,
    status character varying,
    dt_create timestamp without time zone,
    dt_update timestamp without time zone
);

ALTER TABLE ONLY voices.t_party
    ADD CONSTRAINT party_pkey PRIMARY KEY (uuid);

ALTER TABLE ONLY voices.t_party
    ADD CONSTRAINT unique_title_party_key UNIQUE (title);

CREATE TABLE voices.t_voice
(
    uuid uuid,
    user_uuid uuid,
    candidate_uuid uuid,
    party_uuid uuid,
    dt_create timestamp without time zone
);

ALTER TABLE ONLY voices.t_voice
    ADD CONSTRAINT voice_pkey PRIMARY KEY (uuid);
