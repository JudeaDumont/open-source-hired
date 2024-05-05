-- I need the columns to be nullable
-- because only part of a bundle might be built up at a time

ALTER TABLE public.Bundle ALTER COLUMN plaintexttomatch DROP NOT NULL;

ALTER TABLE public.Bundle ALTER COLUMN pdfGuid DROP NOT NULL;

ALTER TABLE public.Bundle ALTER COLUMN wordGuid DROP NOT NULL;

ALTER TABLE public.Bundle ALTER COLUMN plainTextGuid DROP NOT NULL;

ALTER TABLE public.Bundle ALTER COLUMN tieredMatchKeywords DROP NOT NULL;
