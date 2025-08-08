# Settings for the GCC(1) cpu-type "znver4":
#
#	AMD Family 19h core based CPUs with x86-64 instruction set support. 
#	(This supersets BMI, BMI2, CLWB, F16C, FMA, FSGSBASE, AVX,  AVX2,  ADCX,  RDSEED,  MWAITX,  SHA,
#	CLZERO,  AES,  PCLMUL,  CX16,  MOVBE, MMX, SSE, SSE2, SSE3, SSE4A, SSSE3, SSE4.1, SSE4.2, ABM,
#	XSAVEC, XSAVES, CLFLUSHOPT, POPCNT, RDPID, WBNOINVD, PKU, VPCLMULQDQ, VAES, AVX512F, AVX512DQ,
#	AVX512IFMA, AVX512CD, AVX512BW, AVX512VL, AVX512BF16, AVX512VBMI, AVX512VBMI2, AVX512VNNI,
#	AVX512BITALG, AVX512VPOPCNTDQ, GFNI and 64-bit instruction set extensions.)
#
# This tune is recommended for AMD Zen4 CPU (and beyond).
#
DEFAULTTUNE ?= "zen4"

# 
require conf/machine/include/tune-zen3.inc

# Extra tune features
TUNEVALID[zen4] = "Enable AMD x86 (64 bit) Zen 4 Core Architecture specific optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'zen4', ' -march=znver4 -mtune=znver4 ${ADDITIONAL_ISA}', '', d)}"
TUNECONFLICTS[zen4] = "m32 mx32"

# Extra tune selections
AVAILTUNES += "zen4"
TUNE_FEATURES:tune-zen4 = "${TUNE_FEATURES:tune-x86-64} zen4"
BASE_LIB:tune-zen4  = "lib64"
TUNE_PKGARCH:tune-zen4 = "zen4"
PACKAGE_EXTRA_ARCHS:tune-zen4 = "${PACKAGE_EXTRA_ARCHS:tune-zen3} zen4"
QEMU_EXTRAOPTIONS_zen4 = " -cpu EPYC,check=false"

OPENBLAS_TARGET = "ZEN"

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
