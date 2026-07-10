require recipes-kernel/linux/linux-production.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://vtd-intel.cfg \
	file://static_intel_drivers.cfg \
    "

