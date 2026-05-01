FILESEXTRAPATHS:prepend := "${THISDIR}/procps:"

SRC_URI += "file://99-dpdk.conf"

do_install:append() {
	install -d ${D}${sysconfdir}/sysctl.d
	install -m 0644 ${UNPACKDIR}/99-dpdk.conf ${D}${sysconfdir}/sysctl.d
}
