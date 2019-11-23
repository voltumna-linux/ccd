require recipes-core/images/voltumna-sdk.bb
require recipes-devtools/pogo/include/pogo_9.4.2.inc
require recipes-devtools/pylon/include/pylon_6.1.1.19861.inc
require include/ccd.inc

POPULATE_SDK_POST_TARGET_COMMAND += " install_pogo_into_sdk; install_pylon_into_sdk;"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
