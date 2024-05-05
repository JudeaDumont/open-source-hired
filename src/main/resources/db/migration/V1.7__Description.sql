CREATE TABLE public.Description
(
    id bigint  NOT NULL GENERATED ALWAYS AS IDENTITY (START 1 INCREMENT 1 ),
    name character varying(45),
    content character varying(100000),
    CONSTRAINT Description_pkey PRIMARY KEY (id)
)