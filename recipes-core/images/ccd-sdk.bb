require recipes-core/images/voltumna-sdk.inc
require recipes-core/images/elettra-sdk.inc
require include/ccd.inc

IMAGE_INSTALL_append = " librnmshare-dev librnmdpdk-dev \
	openblas-dev gsl-dev itpp-dev fftw-dev libfit-dev \
	libbufferrt-dev libpylon-dev cpptango-dev"
IMAGE_INSTALL_append_s-4125r-x11spw-tf-myricom = " libemergent-dev"

TOOLCHAIN_HOST_TASK_append = " nativesdk-pogo nativesdk-jive \
	nativesdk-python3-pytango nativesdk-openblas-dev \
	nativesdk-librnmshare-dev nativesdk-librnmdpdk-dev \
	nativesdk-gsl-dev nativesdk-itpp-dev nativesdk-fftw-dev \
	nativesdk-libfit-dev nativesdk-libbufferrt-dev \
	nativesdk-libpylon-dev nativesdk-cpptango-dev \
	nativesdk-libemergent-dev"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
