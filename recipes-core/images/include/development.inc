IMAGE_INSTALL:append = " python3-pyelftools openblas-dev gsl-dev \
	itpp-dev fftw-dev libfit-dev libpylon-dev cpptango-dev \
	numactl-dev lapack-dev boost-dev hdf5"

IMAGE_INSTALL:append:fast = " dpdk-dev"
IMAGE_INSTALL:append:rnm = " librnmshare-dev librnmdpdk-dev \
	libbufferrt-dev"

IMAGE_INSTALL:remove:kvm = "libpylon-dev caenvmelib-dev \
	a3818-dev libandor2-dev libpdv-dev libhimage-dev \
	libtucam-dev"

