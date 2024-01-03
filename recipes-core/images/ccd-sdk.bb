require recipes-core/images/voltumna-sdk.inc
require recipes-core/images/elettra-sdk.inc
require include/ccd.inc

IMAGE_INSTALL:append = " openblas-dev gsl-dev itpp-dev fftw-dev \
	libfit-dev libpylon-dev cpptango-dev a3818-dev \
	caenvmelib-dev lapack-dev libandor2-dev libpdv-dev \
	libhimage-dev libtucam-dev"
IMAGE_INSTALL:append:rnm = " librnmshare-dev librnmdpdk-dev \
	libbufferrt-dev" 
IMAGE_INSTALL:remove:kvm = "libpylon-dev caenvmelib-dev \
	a3818-dev libandor2-dev libpdv-dev libhimage-dev \
	libtucam-dev"

TOOLCHAIN_HOST_TASK:append = " nativesdk-pogo nativesdk-jive \
	nativesdk-python3-pytango nativesdk-openblas-dev \
	nativesdk-librnmshare-dev nativesdk-librnmdpdk-dev \
	nativesdk-gsl-dev nativesdk-itpp-dev nativesdk-fftw-dev \
	nativesdk-libfit-dev nativesdk-libbufferrt-dev \
	nativesdk-libpylon-dev nativesdk-cpptango-dev \
	nativesdk-a3818-dev nativesdk-caenvmelib-dev \
	nativesdk-lapack-dev nativesdk-libandor2-dev \
	nativesdk-libpdv-dev nativesdk-libhimage-dev \
	nativesdk-libtucam-dev"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
