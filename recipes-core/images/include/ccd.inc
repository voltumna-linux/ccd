IMAGE_INSTALL_append += "openblas gsl itpp libfftw starter python3-pytango dpdk ffmpeg tiff"

ROOTFS_POSTPROCESS_COMMAND_append += " append_to_osrelease;"
