FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "file://libtiff5.map"

PACKAGECONFIG_remove = "cxx"

LDFLAGS_append = " -Wl,--version-script=${WORKDIR}/libtiff5.map"
