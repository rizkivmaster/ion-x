--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: account; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE account (
    id character varying NOT NULL,
    username character varying,
    firstname character varying,
    lastname character varying,
    gender character varying
);


ALTER TABLE public.account OWNER TO postgres;

--
-- Name: authority; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE authority (
    id character varying NOT NULL,
    action character varying,
    userid character varying,
    hasright boolean,
    haspass boolean
);


ALTER TABLE public.authority OWNER TO postgres;

--
-- Name: authoritypass; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE authoritypass (
    id character varying NOT NULL,
    authorityid character varying,
    passkey character varying
);


ALTER TABLE public.authoritypass OWNER TO postgres;

--
-- Name: bankaccount; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bankaccount (
    id character varying NOT NULL,
    provider character varying,
    accountnumber character varying,
    userid character varying
);


ALTER TABLE public.bankaccount OWNER TO postgres;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customer (
    id character varying NOT NULL,
    userid character varying
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: merchant; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE merchant (
    id character varying NOT NULL,
    userid character varying,
    companyname character varying
);


ALTER TABLE public.merchant OWNER TO postgres;

--
-- Name: savingsaccount; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE savingsaccount (
    id character varying NOT NULL,
    userid character varying,
    balance bigint
);


ALTER TABLE public.savingsaccount OWNER TO postgres;

--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY account (id, username, firstname, lastname, gender) FROM stdin;
\.


--
-- Data for Name: authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY authority (id, action, userid, hasright, haspass) FROM stdin;
\.


--
-- Data for Name: authoritypass; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY authoritypass (id, authorityid, passkey) FROM stdin;
\.


--
-- Data for Name: bankaccount; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bankaccount (id, provider, accountnumber, userid) FROM stdin;
\.


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY customer (id, userid) FROM stdin;
\.


--
-- Data for Name: merchant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY merchant (id, userid, companyname) FROM stdin;
\.


--
-- Data for Name: savingsaccount; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY savingsaccount (id, userid, balance) FROM stdin;
\.


--
-- Name: authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- Name: authoritypass_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY authoritypass
    ADD CONSTRAINT authoritypass_pkey PRIMARY KEY (id);


--
-- Name: bankaccount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bankaccount
    ADD CONSTRAINT bankaccount_pkey PRIMARY KEY (id);


--
-- Name: customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- Name: merchant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY merchant
    ADD CONSTRAINT merchant_pkey PRIMARY KEY (id);


--
-- Name: savingsaccount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY savingsaccount
    ADD CONSTRAINT savingsaccount_pkey PRIMARY KEY (id);


--
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY account
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: user_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY account
    ADD CONSTRAINT user_username_key UNIQUE (username);


--
-- Name: authority_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY authority
    ADD CONSTRAINT authority_userid_fkey FOREIGN KEY (userid) REFERENCES account(id);


--
-- Name: authoritypass_authorityid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY authoritypass
    ADD CONSTRAINT authoritypass_authorityid_fkey FOREIGN KEY (authorityid) REFERENCES authority(id);


--
-- Name: bankaccount_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bankaccount
    ADD CONSTRAINT bankaccount_userid_fkey FOREIGN KEY (userid) REFERENCES account(id);


--
-- Name: customer_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_userid_fkey FOREIGN KEY (userid) REFERENCES account(id);


--
-- Name: merchant_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY merchant
    ADD CONSTRAINT merchant_userid_fkey FOREIGN KEY (userid) REFERENCES account(id);


--
-- Name: savingsaccount_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY savingsaccount
    ADD CONSTRAINT savingsaccount_userid_fkey FOREIGN KEY (userid) REFERENCES account(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

