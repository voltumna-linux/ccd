include andor.inc

inherit module

RPROVIDES:${PN} += "kernel-module-andor"

DEPENDS = "bc-native"

SRC_URI:append = " \
	file://Makefile \
	file://update_kernel_api.patch \
	file://90-andor.rules  \
	file://90-shamrock.rules \
	"

do_compile() {
    cd ${S}/src/driver
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake -f ${WORKDIR}/Makefile \
           KDIR=${STAGING_KERNEL_DIR}   \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}" \
           O=${STAGING_KERNEL_BUILDDIR} \
           KBUILD_EXTRA_SYMBOLS="${KBUILD_EXTRA_SYMBOLS}" \
           ${MAKE_TARGETS}
}

FILES:${PN} += " \
	${libdir}/firmware/andor \
	${sysconfdir}/udev/rules.d \
	"

do_install() {
    cd ${S}/src/driver
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake -f ${WORKDIR}/Makefile \
               KDIR=${STAGING_KERNEL_DIR}   \
               DEPMOD=echo MODLIB="${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}" \
               INSTALL_FW_PATH="${D}${nonarch_base_libdir}/firmware" \
               CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
               O=${STAGING_KERNEL_BUILDDIR} \
               ${MODULES_INSTALL_TARGET}
	
    install -d ${D}${libdir}/firmware/andor
    cp -r ${S}/etc/* ${D}${libdir}/firmware/andor/
 
    install -d ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d/
}
