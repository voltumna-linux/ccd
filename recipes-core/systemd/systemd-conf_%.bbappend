FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:s-4125r-x11spw-tf-myricom = " \
	file://90-myri-mva.network \
	"

FILES:${PN}:append = "${sysconfdir}/systemd/network"

do_install:append() {
	if [ -f ${WORKDIR}/90*.network ]; then
		install -d ${D}${sysconfdir}/systemd/network	
		install	-m 0644 ${WORKDIR}/90*.network \
			${D}${sysconfdir}/systemd/network/
	fi
}
