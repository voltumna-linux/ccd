do_install_append() {
	sed -i 's,^giopMaxMsgSize.*,giopMaxMsgSize = 524288000  # 500 MBytes.,g' ${D}${sysconfdir}/omniORB.cfg
}
