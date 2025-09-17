--
-- PostgreSQL database dump
--

-- Dumped from database version 15.13 (Debian 15.13-0+deb12u1)
-- Dumped by pg_dump version 15.13 (Debian 15.13-0+deb12u1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: escadron; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.escadron (
    id integer NOT NULL,
    nom text
);


ALTER TABLE public.escadron OWNER TO postgres;

--
-- Name: escadron_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.escadron_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.escadron_id_seq OWNER TO postgres;

--
-- Name: escadron_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.escadron_id_seq OWNED BY public.escadron.id;


--
-- Name: escadron id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.escadron ALTER COLUMN id SET DEFAULT nextval('public.escadron_id_seq'::regclass);


--
-- Data for Name: escadron; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.escadron (id, nom) VALUES (1, 'Les elites bleues');
INSERT INTO public.escadron (id, nom) VALUES (2, 'Voiliers de l''espace');
INSERT INTO public.escadron (id, nom) VALUES (3, 'Foudre nocturne');
INSERT INTO public.escadron (id, nom) VALUES (4, 'Griffon d''acier');


--
-- Name: escadron_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.escadron_id_seq', 4, true);


--
-- Name: escadron escadron_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.escadron
    ADD CONSTRAINT escadron_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

