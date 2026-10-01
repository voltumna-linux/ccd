IMAGE_INSTALL:append = " openblas-dev gsl-dev \
	itpp-dev fftw-dev libfit-dev libpylon-dev cpptango-dev \
	boost-dev hdf5 net-snmp-dev libximc-dev \
        libgccjit-dev muparserx-dev python3-zipapp"

IMAGE_INSTALL:append:fast = " python3-pyelftools dpdk-dev"
IMAGE_INSTALL:append:rnm = " librnmshare-dev librnmdpdk-dev \
	libbufferrt-dev"

