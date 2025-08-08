FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:d-9755-h14dsh = " \
	file://static_intel_drivers.cfg \
        file://nr-cpus-512.cfg \
        "


