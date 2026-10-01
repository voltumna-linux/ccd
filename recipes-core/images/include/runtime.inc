IMAGE_INSTALL:append = " hwloc dmidecode starter \
	openblas gsl itpp libfftw libfftwf libfftwl \
	python3-pytango libfit tcpdump users rsync screen netcat \
	vlan libpylon boost hdf5 python3-h5py cpupower libximc \
        turbostat rt-tests iputils-ping iputils-arping \
        net-snmp-client net-snmp-mibs python3-netsnmp perf \
        libgccjit muparserx libtcc python3-scipy cpunoise"

IMAGE_INSTALL:append:fast = " dpdk dpdk-tools"
IMAGE_INSTALL:append:rnm = " rnm-dpdk librnmshare librnmdpdk \
        rnm-dpdk-watch dpdk dpdk-tools libbufferrt"
IMAGE_INSTALL:append:rnm:intel-x86-common = " intel-cmt-cat intel-pcm"

