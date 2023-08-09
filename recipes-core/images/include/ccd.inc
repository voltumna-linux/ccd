IMAGE_INSTALL:append = " lshw hwloc dmidecode starter \
	openblas gsl itpp libfftw python3-pytango libfit \
	iftop tcpdump users rsync netcat vlan lapack \
	libpylon caenvmelib kernel-module-a3818 a3818 \
	libandor kernel-module-edt libpdv edt-utils libhimage \
	libtucam"
IMAGE_INSTALL:append:rnm = " intel-cmt-cat rnm-dpdk librnmshare \
	librnmdpdk rnm-dpdk-watch dpdk dpdk-tools libbufferrt"
IMAGE_INSTALL:remove:kvm = " libpylon caenvmelib \
	kernel-module-a3818 a3818 libandor kernel-module-edt \
	libpdv edt-utils libhimage libtucam"

