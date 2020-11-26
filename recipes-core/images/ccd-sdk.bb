require recipes-core/images/voltumna-sdk.bb
require recipes-devtools/pylon/include/pylon_6.1.1.19861.inc
require include/ccd.inc

TOOLCHAIN_HOST_TASK_append += "nativesdk-pogo"
POPULATE_SDK_POST_TARGET_COMMAND += " install_pylon_into_sdk;"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="Charge-Coupled Device (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
