IMAGE_INSTALL:append = " lshw hwloc dmidecode starter \
	numactl openblas gsl itpp libfftw libfftwf libfftwl \
	python3-pytango libfit tcpdump users rsync netcat \
	vlan lapack libpylon caenvmelib kernel-module-a3818 a3818 \
	libandor2 kernel-module-edt libpdv edt-utils \
	libtucam firebird-modules libdcam libximc libandor3 \
	kernel-module-bitflow libbitflow hdf5 python3-h5py \
	intel-speed-select kernel-module-pixci xclib"

IMAGE_INSTALL:append:rnm = " intel-cmt-cat intel-pcm msr-tools \
	rnm-dpdk librnmshare librnmdpdk rnm-dpdk-watch dpdk \
	dpdk-tools libbufferrt"

IMAGE_INSTALL:remove:kvm = " libpylon caenvmelib \
	kernel-module-a3818 a3818 libandor2 kernel-module-edt \
	libpdv edt-utils libtucam firebird-modules libdcam \
	libximc libandor3 kernel-module-bitflow libbitflow \
        kernel-module-pixci xclib"

