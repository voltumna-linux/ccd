require recipes-core/images/voltumna-sde.bb
require include/ccd.inc

# IMAGE_INSTALL:append = " dpdk-staticdev"
IMAGE_INSTALL:append = " python3-pyelftools"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
