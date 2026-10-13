# voltumna-sde is the Development variant (the only one available as .bb): it
# carries IMAGE_FEATURES empty-root-password/allow-root-login, wanted here and
# NOT present in ccd-sre (runtime). Do not convert to .inc without reviewing
# the root policy.
require recipes-core/images/voltumna-sde.bb
require include/runtime.inc
require include/development.inc
VARIANT = "Charge-Coupled Device (Development)"
