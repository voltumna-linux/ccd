FILESEXTRAPATHS:prepend := "${THISDIR}/libpam:"

SRC_URI += "file://dpdk.conf"

# The limits in dpdk.conf target group @controls: need the recipe creating it
RDEPENDS:${PN}:class-target += "users"

do_install:append() {
	install -d ${D}${sysconfdir}/security/limits.d/
	install -m 0644 ${WORKDIR}/dpdk.conf ${D}${sysconfdir}/security/limits.d/

	# The security/limits.d limits (memlock/rtprio for dpdk) only apply if
	# pam_limits.so is in the session stack: login/su/sshd have it already,
	# common-session(-noninteractive) no.
	sed -i '/^session[[:space:]]\+required[[:space:]]\+pam_unix\.so/a session\trequired\tpam_limits.so' \
		${D}${sysconfdir}/pam.d/common-session \
		${D}${sysconfdir}/pam.d/common-session-noninteractive
}
