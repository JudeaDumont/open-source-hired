CREATE TABLE public.Bundle
(
    id bigint  NOT NULL GENERATED ALWAYS AS IDENTITY (START 1 INCREMENT 1 ),
    name character varying(45) NOT NULL,
    plainTextToMatch character varying(100000) NOT NULL,
    pdfGuid character(36) NOT NULL,
    wordGuid character(36) NOT NULL,
    plainTextGuid character(36) NOT NULL,
    tieredMatchKeywords character varying(100000) NOT NULL,
    CONSTRAINT Bundle_pkey PRIMARY KEY (id)
)