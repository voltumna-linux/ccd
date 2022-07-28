FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_s-4125r-x11spw-tf-myricom += " \
	file://90-myri-mva.network \
	"

FILES_${PN} += "${sysconfdir}/systemd/network"

do_install_append() {
	if [ -f ${WORKDIR}/90*.network ]; then
		install -d ${D}${sysconfdir}/systemd/network	
		install	-m 0644 ${WORKDIR}/90*.network \
			${D}${sysconfdir}/systemd/network/
	fi
}
