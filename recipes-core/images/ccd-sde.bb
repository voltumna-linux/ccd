require recipes-core/images/voltumna-sde.inc
require recipes-devtools/pylon/include/pylon_6.1.1.19861.inc
require include/ccd.inc
require include/ccd-sxe.inc

IMAGE_INSTALL_append += " bcc"
IMAGE_PREPROCESS_COMMAND += " install_pylon_into_sde;"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
