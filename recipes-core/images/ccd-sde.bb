require recipes-core/images/voltumna-sde.bb
require include/ccd.inc

IMAGE_INSTALL_append += " dpdk-staticdev"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Development)"
	MACHINE="${MACHINE}"
	__EOF__
}