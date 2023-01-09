SUMMARY = "Fundamental library for scientific computing for Python"
DESCRIPTION = "SciPy provides many user-friendly and efficient numerical routines, such as routines for numerical integration, interpolation, optimization, linear algebra, and statistics."
HOMEPAGE = "https://www.scipy.org/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=011ccf01b7e0590d9435a864fc6a4d2b"

# SRC_URI[md5sum] = "3a97689656f33f67614000459ec08585"
# SRC_URI[sha256sum] = "dee1bbf3a6c8f73b6b218cb28eed8dd13347ea2f87d572ce19b289d6fd3fbc59"
SRC_URI[md5sum] = "77be719dcb5a81ddd6c3260bc37a2e59"
SRC_URI[sha256sum] = "31f7cfa93b01507c935c12b535e24812594002a02a56803d7cd063e9920d25e8"

inherit pypi setuptools3

DEPENDS:append = " \
	openblas \
	lapack \
	${PYTHON_PN}-pybind11-native \
	${PYTHON_PN}-numpy-native \
"

RDEPENDS:${PN}:append = " \
	${PYTHON_PN}-numpy \
"
