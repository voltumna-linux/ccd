require recipes-core/images/voltumna-sdk.inc
require recipes-core/images/elettra-sdk.inc
require include/ccd.inc

IMAGE_INSTALL:append = " librnmshare-dev librnmdpdk-dev \
	openblas-dev gsl-dev itpp-dev fftw-dev libfit-dev \
	libbufferrt-dev libpylon-dev cpptango-dev a3818-dev \
	caenvmelib-dev lapack-dev libandor-dev intel-cmt-cat"
IMAGE_INSTALL:remove:kvm = "librnmshare-dev librnmdpdk-dev \
	libbufferrt-dev libpylon-dev a3818-dev \
	caenvmelib-dev libandor-dev intel-cmt-cat"

TOOLCHAIN_HOST_TASK:append = " nativesdk-pogo nativesdk-jive \
	nativesdk-python3-pytango nativesdk-openblas-dev \
	nativesdk-librnmshare-dev nativesdk-librnmdpdk-dev \
	nativesdk-gsl-dev nativesdk-itpp-dev nativesdk-fftw-dev \
	nativesdk-libfit-dev nativesdk-libbufferrt-dev \
	nativesdk-libpylon-dev nativesdk-cpptango-dev \
	nativesdk-a3818-dev nativesdk-caenvmelib-dev \
	nativesdk-lapack-dev nativesdk-libandor-dev"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
