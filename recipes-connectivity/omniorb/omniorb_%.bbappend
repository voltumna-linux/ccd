do_install:append() {
	sed -i 's,^giopMaxMsgSize.*,giopMaxMsgSize = 524288000,g' ${D}${sysconfdir}/omniORB.cfg
}
