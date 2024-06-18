FILESEXTRAPATHS:prepend := "${THISDIR}/libpam:"

SRC_URI += "file://dpdk.conf"

do_install:append() {
	install -d ${D}${sysconfdir}/security/limits.d/
	install -m 0644 ${WORKDIR}/dpdk.conf ${D}${sysconfdir}/security/limits.d/
}
