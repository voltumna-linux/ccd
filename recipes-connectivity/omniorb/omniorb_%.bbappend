do_install:append() {
	# 500MiB: GIOP threshold for large TANGO objects; if the key is missing
	# the sed is a silent no-op -> failing the build is better.
	grep -q '^giopMaxMsgSize' ${D}${sysconfdir}/omniORB.cfg ||
		bbfatal "giopMaxMsgSize missing from omniORB.cfg: threshold not applied"
	sed -i 's,^giopMaxMsgSize.*,giopMaxMsgSize = 524288000,g' ${D}${sysconfdir}/omniORB.cfg
}
