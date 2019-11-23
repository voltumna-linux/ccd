require recipes-core/images/voltumna-sre.bb
require recipes-devtools/pylon/include/pylon_6.1.1.19861.inc
require include/ccd.inc

IMAGE_PREPROCESS_COMMAND += " install_pylon_into_sre;"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
