FILESEXTRAPATHS:prepend := "${THISDIR}/libpam:"

SRC_URI:append = "file://dpdk.conf"

do_install:append() {
	install -d ${D}${sysconfdir}/security/limits.d/
	install -m 0644 ${UNPACKDIR}/dpdk.conf ${D}${sysconfdir}/security/limits.d/
}
