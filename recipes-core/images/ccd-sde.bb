require recipes-core/images/voltumna-sde.bb
require include/runtime.inc
require include/development.inc
VARIANT = "Charge-Coupled Device (Development)"

IMAGE_INSTALL_append_s-4125r-x11spw-tf-myricom = " libemergent-dev"
