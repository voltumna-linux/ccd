IMAGE_INSTALL_append += "openblas gsl itpp libfftw python3-pytango dpdk dpdk-staticdev ffmpeg tiff"

ROOTFS_POSTPROCESS_COMMAND_append += " append_to_osrelease;"
