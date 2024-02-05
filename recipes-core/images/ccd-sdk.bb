require recipes-core/images/voltumna-sdk.inc
require recipes-core/images/elettra-sdk.inc
require include/development.inc
require include/cross-development.inc

IMAGE_INSTALL_append_s-4125r-x11spw-tf-myricom = " libemergent-dev"
