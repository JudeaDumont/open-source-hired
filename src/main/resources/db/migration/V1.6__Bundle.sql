ALTER TABLE public.Bundle
ADD jobDescriptionName character(36); -- nullable because I want existing bundles to not break anything