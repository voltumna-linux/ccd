include andor.inc

DEPENDS = "libusb-compat"

PACKAGES += " ${BPN}-examples"
FILES:${PN}-examples += "${datadir}/andor/examples"

do_install () {
 	install -d ${D}${includedir} ${D}${libdir}
 	install -m 0644 ${S}/include/* ${D}${includedir}
	for p in `ls ${S}/lib/lib*x86_64*${PV}`
	do
		n=`basename $p | sed -n "s,\(.*\)-x86_64.so.${PV},\1,p"`
	 	lib="${n}-x86_64.so.${PV}"
	 	install -m 0644 ${S}/lib/${lib} ${D}${libdir}
	 	ln -sfrn ${D}${libdir}/$lib ${D}${libdir}/$n.so
	 	ln -sfrn ${D}${libdir}/$lib ${D}${libdir}/$n.so.2
	done
 	
	install -d ${D}${docdir}/andor
	cp -r ${S}/doc/* ${D}${docdir}/andor/
	
	install -d ${D}${datadir}/andor/examples
	cp -r ${S}/examples/console/* ${D}${datadir}/andor/examples
}

BBCLASSEXTEND = "nativesdk"
