DESCRIPTION = "Emergent SDK Installer"
HOMEPAGE = "https://emergentvisiontec.com/resources/?tab=ss"
LICENSE = "CLOSED"

BUILDNUMBER="20608"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
	file://esdk-installer_${PV}.${BUILDNUMBER}.zip \
	file://fix-paths.patch \
	file://Porting-from-5.3-to-5.4.patch \
	file://myri-mva.conf \
	file://90-myri-mva.rules \
	"
SRC_URI[sha256sum] = "4c508e695d2b6562b917e324a531173172d2208674eb852148757d080ee71a78"
COMPATIBLE_HOST = "x86_64.*-linux"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT  = "1"

PACKAGES = "kernel-module-myricom-mva libmva libmva-dev libgenicam libemergent libemergent-dev"

DEPENDS += "virtual/kernel"
FILES_kernel-module-myricom-mva = "${libdir}/modules"

INSANE_SKIP_libmva = "ldflags"
SOLIBS_libmva = ".so"
FILES_SOLIBSDEV_libmva = ""
FILES_libmva = "${libdir}/libmva.so ${sysconfdir} ${sbindir} ${libdir}/udev"
FILES_libmva-dev = "${includedir}/mva*.h"
RDEPENDS_libmva += "gawk"

INSANE_SKIP_libgenicam = "ldflags"
SOLIBS_libgenicam = ".so"
FILES_SOLIBSDEV_libgenicam = ""
FILES_libgenicam = "${libdir}/lib*gcc48*.so"

INSANE_SKIP_libemergent = "dev-so file-rdeps"
RDEPENDS_libemergent = "tiff libavformat zlib libmva libgenicam"
FILES_libemergent = "${libdir}/libEmergentCamera*.so* ${libdir}/libEmergentG*.so"
RDEPENDS_libemergent-dev = "libemergent"
FILES_libemergent-dev = "${includedir}/*mergent*.h \
		${includedir}/EvtParamAttribute.h \
		${includedir}/GenTL.h \
		${includedir}/gigevisiondeviceinfo.h \
		${includedir}/networkinterfacecontroller.h \
		${includedir}/platformsymbols.h"


do_extract_data() {
	tar zxf emergent_camera_${PV}.${BUILDNUMBER}-ubuntu18.04.4.x64.tgz 
	ar x emergent_camera.deb
	tar Jxf  data.tar.xz -C "${S}"
}

do_unpack[depends] += "unzip-native:do_populate_sysroot"
do_unpack[depends] += "xz-native:do_populate_sysroot"
python do_unpack_append() {
    bb.build.exec_func('do_extract_data', d)
}

do_compile() {
	chmod +x opt/EVT/myricom_mva/sbin/rebuild.sh \
		opt/EVT/myricom_mva/src/driver/linux/mal_check_headers.sh
	opt/EVT/myricom_mva/sbin/rebuild.sh "${S}/opt/EVT/myricom_mva" \
		"${STAGING_KERNEL_DIR}" "${STAGING_KERNEL_BUILDDIR}"
}

do_install () {
	KERNEL_VERSION="`ls ${STAGING_KERNEL_BUILDDIR}/System.map-* | sed 's,.*System.map-\(.*\),\1,g'`"
 	install -m 0755 -d ${D}${libdir}/modules/${KERNEL_VERSION}/extra
	install -m 0644 opt/EVT/myricom_mva/sbin/myri_mva.ko ${D}${libdir}/modules/${KERNEL_VERSION}/extra

	install -d ${D}${sysconfdir}/modules-load.d/
	install -m 0644 ${WORKDIR}/myri-mva.conf ${D}${sysconfdir}/modules-load.d/

	install -d ${D}${libdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/90-myri-mva.rules ${D}${libdir}/udev/rules.d
	
	install -d ${D}${sbindir}
	install -m 0755 opt/EVT/myricom_mva/sbin/myri_create_devs ${D}${sbindir}

	install -d ${D}${includedir} ${D}${libdir}
	install -m 0755 opt/EVT/myricom_mva/lib/libmva.so ${D}${libdir}
	install -m 0644 opt/EVT/myricom_mva/include/mva*.h ${D}${includedir}

	install -m 0755 opt/EVT/eSDK/genicam/bin/Linux64_x64/lib*gcc48*.so ${D}${libdir}

	install -m 0755 opt/EVT/eSDK/lib/libEmergentCamera*.so.* ${D}${libdir}
	cp -P opt/EVT/eSDK/lib/libEmergentCamera*.so ${D}${libdir}
	cp opt/EVT/eSDK/lib/libEmergentG*.so ${D}${libdir}

	install -m 0644 opt/EVT/eSDK/include/*mergent*.h \
		opt/EVT/eSDK/include/EvtParamAttribute.h \
		opt/EVT/eSDK/include/GenTL.h \
		opt/EVT/eSDK/include/gigevisiondeviceinfo.h \
		opt/EVT/eSDK/include/networkinterfacecontroller.h \
		opt/EVT/eSDK/include/platformsymbols.h \
		${D}${includedir}
}

BBCLASSEXTEND = "native nativesdk"
