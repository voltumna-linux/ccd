require recipes-core/images/voltumna-sre.inc
require include/ccd.inc

IMAGE_INSTALL_append_s-4125r-x11spw-tf-myricom = " libemergent"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Runtime)"
	MACHINE="${MACHINE}"
	__EOF__
}
