IMAGE_INSTALL:append = " lshw hwloc dmidecode starter rnm-dpdk librnmshare \
	librnmdpdk rnm-dpdk-watch openblas gsl itpp libfftw python3-pytango \
	dpdk dpdk-tools libfit libbufferrt libpylon iftop tcpdump users rsync \
	lapack caenvmelib kernel-module-a3818 a3818 kernel-module-andor libandor"
IMAGE_INSTALL:remove:kvm = " rnm-dpdk librnmshare \
	librnmdpdk rnm-dpdk-watch dpdk dpdk-tools libbufferrt libpylon \
	caenvmelib kernel-module-a3818 a3818 kernel-module-andor libandor"
