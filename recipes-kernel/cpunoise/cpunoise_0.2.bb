SUMMARY = "CPU noise tracing and analysis for full-dynticks Linux systems"
DESCRIPTION = "Collect and analyse kernel interference on nohz_full CPUs. \
Includes the user_loop workload, trace collector and configuration checks."
HOMEPAGE = "https://git.kernel.org/pub/scm/linux/kernel/git/frederic/cpunoise.git/"

# This upstream revision contains no license file or license declaration.
# CLOSED is a conservative Yocto placeholder, not an upstream license grant.
# Replace it and add LIC_FILES_CHKSUM once upstream licensing is clarified.
LICENSE = "CLOSED"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/frederic/cpunoise.git;protocol=https;branch=master"
SRCREV = "64441350999124f44f43f491b8f05fcaea39d0a3"

# Wrynose's python3-core includes subprocess, re, optparse and collections.
RDEPENDS:${PN} = "python3-core python3-compression python3-statistics"

do_configure[noexec] = "1"

do_compile() {
    # The upstream Makefile hardcodes gcc and ignores the Yocto flags.
    ${CC} ${CPPFLAGS} ${CFLAGS} "${S}/user_loop.c" \
        -o "${S}/user_loop" ${LDFLAGS}
}

do_install() {
    install -d "${D}${bindir}" "${D}${libexecdir}/${BPN}"

    install -m 0755 "${S}/user_loop" "${D}${libexecdir}/${BPN}/user_loop"
    for script in cpunoise.py cpunoise_lib.py noise_parse.py check_configs.py log_output.py; do
        install -m 0644 "${S}/$script" "${D}${libexecdir}/${BPN}/$script"
    done

    # Locate the installed workload while leaving ./trace in the caller's CWD.
    sed -i 's|"\./user_loop"|"${libexecdir}/${BPN}/user_loop"|' \
        "${D}${libexecdir}/${BPN}/cpunoise.py"

    cat > "${D}${bindir}/cpunoise" <<'EOF'
#!/bin/sh
exec ${bindir}/python3 -B ${libexecdir}/${BPN}/cpunoise.py "$@"
EOF

    cat > "${D}${bindir}/cpunoise-parse" <<'EOF'
#!/bin/sh
exec ${bindir}/python3 -B ${libexecdir}/${BPN}/noise_parse.py "$@"
EOF

    chmod 0755 "${D}${bindir}/cpunoise" "${D}${bindir}/cpunoise-parse"
}

FILES:${PN} += "${libexecdir}/${BPN}"
