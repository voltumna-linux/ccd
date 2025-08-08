# Settings for the GCC(1) cpu-type "znver5":
#
#	AMD Family 1ah core based CPUs with x86-64 instruction set support.
#	(This supersets BMI, BMI2, CLWB, F16C, FMA, FSGSBASE, AVX, AVX2, ADCX, RDSEED, MWAITX, SHA,
#	CLZERO, AES, PCLMUL, CX16, MOVBE, MMX, SSE, SSE2, SSE3, SSE4A, SSSE3, SSE4.1, SSE4.2, ABM,
#	XSAVEC, XSAVES, CLFLUSHOPT, POPCNT, RDPID, WBNOINVD, PKU, VPCLMULQDQ, VAES, AVX512F, AVX512DQ,
#	AVX512IFMA, AVX512CD, AVX512BW, AVX512VL, AVX512BF16, AVX512VBMI, AVX512VBMI2, AVX512VNNI,
#	AVX512BITALG, AVX512VPOPCNTDQ, GFNI, AVXVNNI, MOVDIRI, MOVDIR64B, AVX512VP2INTERSECT,
#	PREFETCHI and 64-bit instruction set extensions.)
#
# This tune is recommended for AMD Zen5 CPU (and beyond).
#
DEFAULTTUNE ?= "zen5"

# 
require conf/machine/include/tune-zen4.inc

# Extra tune features
TUNEVALID[zen5] = "Enable AMD x86 (64 bit) Zen 5 Core Architecture specific optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'zen5', ' -march=znver5 -mtune=znver5 ${ADDITIONAL_ISA}', '', d)}"
TUNECONFLICTS[zen5] = "m32 mx32"

# Extra tune selections
AVAILTUNES += "zen5"
TUNE_FEATURES:tune-zen5 = "${TUNE_FEATURES:tune-x86-64} zen5"
BASE_LIB:tune-zen5  = "lib64"
TUNE_PKGARCH:tune-zen5 = "zen5"
PACKAGE_EXTRA_ARCHS:tune-zen5 = "${PACKAGE_EXTRA_ARCHS:tune-zen4} zen5"
QEMU_EXTRAOPTIONS_zen5 = " -cpu EPYC,check=false"

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

