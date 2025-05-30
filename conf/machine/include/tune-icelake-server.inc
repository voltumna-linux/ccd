# Settings for the GCC(1) cpu-type "icelake-server":
#
#     Intel Icelake Server CPU with 64-bit extensions, MOVBE, MMX, SSE, SSE2, SSE3, SSSE3,
#     SSE4.1, SSE4.2, POPCNT, PKU, AVX, AVX2, AES, PCLMUL, FSGSBASE, RDRND, FMA, BMI,
#     BMI2, F16C, RDSEED, ADCX, PREFETCHW, CLFLUSHOPT, XSAVEC, XSAVES, AVX512F,
#     AVX512VL, AVX512BW, AVX512DQ, AVX512CD, AVX512VBMI, AVX512IFMA, SHA, CLWB, UMIP,
#     RDPID, GFNI, AVX512VBMI2, AVX512VPOPCNTDQ, AVX512BITALG, AVX512VNNI, VPCLMULQDQ,
#     VAES, PCONFIG and WBNOINVD instruction set support.
#
# This tune is recommended for Intel Icelake server CPU (and beyond).
#
DEFAULTTUNE ?= "icelake-server-64"

# Include the previous tune to pull in PACKAGE_EXTRA_ARCHS
require tune-cascadelake.inc

# Extra tune features
TUNEVALID[icelake-server] = "Enable icelake-server pecific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'icelake-server', ' -march=icelake-server -mtune=icelake-server ${ADDITIONAL_ISA}', '', d)}"
TUNECONFLICTS[icelake-server] = "m32 mx32"

# Extra tune selections
AVAILTUNES += "icelake-server-64"
TUNE_FEATURES:tune-icelake-server-64 = "${TUNE_FEATURES:tune-x86-64} icelake-server"
BASE_LIB:tune-icelake-server-64 = "lib64"
TUNE_PKGARCH:tune-icelake-server-64 = "icelake-server-64"
PACKAGE_EXTRA_ARCHS:tune-icelake-server-64 = "${PACKAGE_EXTRA_ARCHS:tune-cascadelake-64} icelake-server-64"
QEMU_EXTRAOPTIONS_icelake-server-64 = " -cpu Icelake-Server"

OPENBLAS_TARGET = "SKYLAKEX"

ADDITIONAL_ISA = "${@bb.utils.contains('MACHINE_FEATURES', 'highly-optimized', '', ' ${ADVANCED_ISA}', d)}"
ADVANCED_ISA = " \
-mno-avx \
-mno-avx2 \
-mno-avx512f \
-mno-avx512cd \
-mno-avx512dq \
-mno-avx512bw \
-mno-avx512vl \
-mno-avx512ifma \
-mno-avx512vbmi \
-mno-avx512vbmi2 \
-mno-avx512vnni \
-mno-avx512bitalg \
-mno-avx512vpopcntdq \
"

