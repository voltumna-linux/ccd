FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://force-irq-affinity \
	file://force-irq-affinity.service \
	"

FILES_${PN}_append = "${base_sbindir}/force-irq-affinity"

do_install_append() {
	install -d ${D}${base_sbindir}
	install -m 0755 ${WORKDIR}/force-irq-affinity \
		${D}${base_sbindir}

	install -d ${D}${systemd_unitdir}/system \
		${D}${sysconfdir}/systemd/system/multi-user.target.wants
	install -m 0644 ${WORKDIR}/force-irq-affinity.service \
		${D}${systemd_unitdir}/system
	ln -sf ${systemd_unitdir}/system/force-irq-affinity.service \
		${D}${sysconfdir}/systemd/system/multi-user.target.wants/force-irq-affinity.service

}
