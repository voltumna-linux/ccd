IMAGE_INSTALL:append = " lshw hwloc dmidecode starter \
	numactl openblas gsl itpp libfftw libfftwf libfftwl \
	python3-pytango libfit tcpdump users rsync netcat \
	vlan lapack libpylon hdf5 python3-h5py cpupower"

IMAGE_INSTALL:append:fast = " dpdk dpdk-tools"
IMAGE_INSTALL:append:rnm = " rnm-dpdk librnmshare librnmdpdk \
        rnm-dpdk-watch dpdk dpdk-tools libbufferrt"
IMAGE_INSTALL:append:rnm:intel-x86-common = " intel-cmt-cat intel-pcm \
        intel-speed-select"

IMAGE_INSTALL:remove:kvm = " libpylon caenvmelib \
	kernel-module-a3818 a3818 libandor2 kernel-module-edt \
	libpdv edt-utils libhimage libtucam"

