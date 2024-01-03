include andor3.inc

DEPENDS += "libusb-compat numactl curl"

# TODO Remove file-rdeps as soon as libBFSOciLib.9.08.so is packaged
INSANE_SKIP:${PN} += "already-stripped dev-so file-rdeps"

PACKAGES += " ${BPN}-examples"
FILES:${PN}-examples += "${datadir}/${BPN}/examples"

FILES:${PN} += " \
	${sysconfdir}/apogee \
	${sysconfdir}/udev/rules.d \
	${libdir} \
	"

FILES_SOLIBSDEV = ""

do_install () {
 	install -d ${D}${includedir}/GenAPIinc ${D}${libdir}
 	install -m 0644 ${S}/inc/* ${D}${includedir}
	cp -r ${S}/GenAPIinc/* ${D}${includedir}/GenAPIinc

	for p in `ls ${S}/x86_64/lib*3.15*`
	do
		n=`basename $p | sed -n "s,\(.*\).so.*,\1,p"`
		v=`basename $p | sed -n "s,.*.so.\(.*\),\1,p"`
	 	lib="${n}.so.${v}"
	 	install -m 0644 ${S}/x86_64/${lib} ${D}${libdir}
	 	ln -sfrn ${D}${libdir}/$lib ${D}${libdir}/$n.so
	 	ln -sfrn ${D}${libdir}/$lib ${D}${libdir}/$n.so.3
	done
	cp -r ${S}/x86_64/GenAPI/* ${D}${libdir}
 	
	install -d ${D}${docdir}/${BPN}
	cp -r ${S}/doc/* ${D}${docdir}/${BPN}/
	
	install -d ${D}${datadir}/${BPN}/examples
	cp -r ${S}/examples/* ${D}${datadir}/${BPN}/examples

	tar zxf ${S}/etc-Apogee-camera.tgz -C ${WORKDIR} --strip-components 2
	install -d ${D}${sysconfdir}/apogee/camera
	install -m 0644 ${WORKDIR}/camera/* ${D}${sysconfdir}/apogee/camera
 
	install -d ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${S}/etc/*.rules ${D}${sysconfdir}/udev/rules.d/
}

BBCLASSEXTEND = "nativesdk"
