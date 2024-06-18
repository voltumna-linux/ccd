IMAGE_INSTALL:append = " lshw hwloc dmidecode starter \
	openblas gsl itpp libfftw libfftwf libfftwl \
	python3-pytango libfit tcpdump users rsync netcat \
	vlan lapack libpylon"

IMAGE_INSTALL:append:rnm = " intel-cmt-cat intel-pcm msr-tools \
	rnm-dpdk librnmshare librnmdpdk rnm-dpdk-watch dpdk \
	dpdk-tools libbufferrt"

IMAGE_INSTALL:remove:kvm = " libpylon caenvmelib \
	kernel-module-a3818 a3818 libandor2 kernel-module-edt \
	libpdv edt-utils libhimage libtucam"

