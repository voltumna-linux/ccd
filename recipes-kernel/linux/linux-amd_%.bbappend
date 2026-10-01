require recipes-kernel/linux/linux-production.inc

# Use kernel.bbclass installation: AMD's override hardcodes /lib/modules and
# omits the kernel image. The class respects nonarch_base_libdir for usrmerge.
do_install() {
    kernel_do_install
}

# Restore the class package layout and enforce usrmerge QA for modules too.
FILES:${KERNEL_PACKAGE_NAME}-modules:remove = "/boot /lib/modules/${KERNEL_VERSION}/* /lib/modules/${KERNEL_VERSION}/modules*"
INSANE_SKIP:${KERNEL_PACKAGE_NAME}-modules:remove = "usrmerge"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://vtd-amd.cfg \
        file://amd-extra.cfg \
	file://static_intel_drivers.cfg \
        "

# static_intel_drivers.cfg is NOT a copy-paste: AMD boards (e.g. H14DSH)
# have Intel NICs and must use the statically linked drivers.

SRC_URI:append:d-9755-h14dsh = " \
        file://nr-cpus-512.cfg \
        "
