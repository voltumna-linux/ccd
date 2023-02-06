require recipes-core/images/voltumna-sde.bb
require include/ccd.inc

IMAGE_INSTALL:append = " librnmshare-dev librnmdpdk-dev \
	openblas-dev gsl-dev itpp-dev fftw-dev libfit-dev \
	libbufferrt-dev libpylon-dev cpptango-dev"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
