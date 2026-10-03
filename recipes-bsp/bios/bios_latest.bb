DESCRIPTION = "Provides BIOS upgrade and configuration files"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_HOST = "x86_64.*-linux"

RDEPENDS:${PN}:append:x11dph-t = " sum"
RDEPENDS:${PN}:append:x12sdv-4c-sp6f = " sum"
RDEPENDS:${PN}:append:h14dsh = " saa"

SRC_URI = " file://bios_configuration.bin"
SRC_URI:append:x11dph-t = " https://www.supermicro.com/Bios/softfiles/32281/X11DPH-I,T,Tq_4.7_AS1.74.25_SUM2.15.0.zip;subdir=${BPN};name=bios-x11dph-t"
SRC_URI:append:x12sdv-4c-sp6f = " https://www.supermicro.com/Bios/softfiles/30600/X12SDV-xC-SP6F_2.2a_AS01.06.08_SAA1.5.0-p4.zip;subdir=${BPN};name=bios-x12sdv-4c-sp6f"
SRC_URI:append:h14dsh = " https://www.supermicro.com/Bios/softfiles/31898/H14DSH_1.9_AS01.07.05.03_SAA1.5.0-p2.zip;subdir=${BPN};name=bios-h14dsh"

SRC_URI[bios-x11dph-t.sha256sum] = "4f5a15479bd309b7563a9f9bef7c420cd163aa225d46a5a25a602ecc6a808c47"
SRC_URI[bios-x12sdv-4c-sp6f.sha256sum] = "14966c60ad558372c61f44bd3684887b379978815fb0561858e49ef3f6452568"
SRC_URI[bios-h14dsh.sha256sum] = "dce23a6dfe5582f87e0102188c9f20fb3212f743bee1a67e8d109e98617532b5"

S = "${UNPACKDIR}/${BPN}"
PACKAGES = "${BPN}"
INSANE_SKIP:${PN} += "already-stripped ldflags file-rdeps debug-files"

do_extract_bundled() {
	unzip ${S}/BIOS*.zip -d ${S}/BIOS
	unzip ${S}/BMC*.zip -d ${S}/BMC
	chmod -R u+w ${S}/BIOS ${S}/BMC
}

python do_unpack:append:x11dph-t() {
    bb.build.exec_func('do_extract_bundled', d)
}

python do_unpack:append:x12sdv-4c-sp6f() {
    bb.build.exec_func('do_extract_bundled', d)
}

python do_unpack:append:h14dsh() {
    bb.build.exec_func('do_extract_bundled', d)
}

do_install() {
	install -d ${D}${datadir}/${BPN}
	install -m 0444 ${UNPACKDIR}/bios_configuration.bin ${D}${datadir}/${BPN}
}

do_install:append:x11dph-t() {
	install -d ${D}${datadir}/${BPN}
	install -m 0444 ${S}/BMC/BMC*/BMC*.bin ${S}/BIOS/BIOS*/BIOS*.bin \
		${D}${datadir}/${BPN}
}

do_install:append:x12sdv-4c-sp6f() {
	install -d ${D}${datadir}/${BPN}
	install -m 0444 ${S}/BMC/BMC*.bin ${S}/BIOS/BIOS*.bin \
		${D}${datadir}/${BPN}
}

do_install:append:h14dsh() {
	install -d ${D}${datadir}/${BPN}
	install -m 0444 ${S}/BMC/BMC*.bin ${S}/BIOS/BIOS*.bin \
		${D}${datadir}/${BPN}
}
