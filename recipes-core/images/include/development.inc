IMAGE_INSTALL:append = " python3-pyelftools openblas-dev gsl-dev \
	itpp-dev fftw-dev libfit-dev libpylon-dev cpptango-dev \
	a3818-dev caenvmelib-dev lapack-dev libandor2-dev \
	libpdv-dev libhimage-dev libtucam-dev"

IMAGE_INSTALL:append:rnm = " librnmshare-dev librnmdpdk-dev \
	libbufferrt-dev" 

IMAGE_INSTALL:remove:kvm = "libpylon-dev caenvmelib-dev \
	a3818-dev libandor2-dev libpdv-dev libhimage-dev \
	libtucam-dev"

