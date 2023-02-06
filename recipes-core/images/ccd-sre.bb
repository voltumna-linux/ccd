require recipes-core/images/voltumna-sre.inc
require include/ccd.inc

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Runtime)"
	MACHINE="${MACHINE}"
	__EOF__
}
