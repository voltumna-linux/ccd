IMAGE_INSTALL:append = " hwloc dmidecode starter \
	numactl openblas gsl itpp libfftw libfftwf libfftwl \
	python3-pytango libfit tcpdump users rsync screen netcat \
	vlan lapack libpylon boost hdf5 python3-h5py cpupower libximc \
        turbostat rt-tests iputils-ping iputils-arping \
        net-snmp-client net-snmp-mibs python3-netsnmp perf"

IMAGE_INSTALL:append:fast = " dpdk dpdk-tools"
IMAGE_INSTALL:append:rnm = " rnm-dpdk librnmshare librnmdpdk \
        rnm-dpdk-watch dpdk dpdk-tools libbufferrt"
IMAGE_INSTALL:append:rnm:intel-x86-common = " intel-cmt-cat intel-pcm"

IMAGE_INSTALL:remove:kvm = " libpylon caenvmelib \
	kernel-module-a3818 a3818 libandor2 kernel-module-edt \
	libpdv edt-utils libtucam firebird-modules libdcam \
	libximc libandor3 kernel-module-bitflow libbitflow \
        kernel-module-pixci pixci-utils xclib"

