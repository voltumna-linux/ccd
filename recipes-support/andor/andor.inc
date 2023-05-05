DESCRIPTION = "Andor SDK for CCD cameras"
HOMEPAGE = "https://andor.oxinst.com/downloads/"
LICENSE = "CLOSED"

SRC_URI = " \
	file://andor-${PV}.tar.gz \
	"
SRC_URI[sha256sum] = "171bf4875c793a7d0ed354890698eb4c7491a5de3441a8beff61525284956278"

COMPATIBLE_HOST = "x86_64.*-linux"
S = "${WORKDIR}/andor"
