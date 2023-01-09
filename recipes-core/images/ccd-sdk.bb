require recipes-core/images/voltumna-sdk.inc
require include/ccd.inc

# IMAGE_INSTALL:append = " dpdk-staticdev"
TOOLCHAIN_HOST_TASK:append = " nativesdk-pogo"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
