FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "file://libtiff5.map"

PACKAGECONFIG:remove = "cxx"

LDFLAGS:append = " -Wl,--version-script=${WORKDIR}/libtiff5.map"

BBCLASSEXTEND = "native nativesdk"
