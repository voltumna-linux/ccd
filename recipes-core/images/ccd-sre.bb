require recipes-core/images/voltumna-sre.inc
require include/runtime.inc
VARIANT = "Charge-Coupled Device (Runtime)"

IMAGE_INSTALL_append_s-4125r-x11spw-tf-myricom = " libemergent"
