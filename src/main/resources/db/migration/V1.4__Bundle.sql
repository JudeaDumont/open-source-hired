ALTER TABLE public.Bundle
ADD jobDescriptionGuid character(36); -- nullable because I want existing bundles to not break anything