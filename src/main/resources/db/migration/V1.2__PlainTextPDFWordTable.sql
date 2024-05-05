CREATE TABLE public.PlainTextPDFWord
(
    id bigint  NOT NULL GENERATED ALWAYS AS IDENTITY (START 1 INCREMENT 1 ),
    name character varying(45) NOT NULL,
    plainTextToMatch character varying(100000) NOT NULL,
    pdfGuid character(36) NOT NULL,
    wordGuid character(36) NOT NULL,
    CONSTRAINT plaintextpdfword_pkey PRIMARY KEY (id)
)