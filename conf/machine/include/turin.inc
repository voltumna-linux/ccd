#@TYPE: Machine
#@NAME: Turin

#@DESCRIPTION: Machine configuration for Turin systems

require conf/machine/include/tune-zen4.inc
require conf/machine/include/uart.inc

MACHINEOVERRIDES =. "amd:amdx86:turin:"
ALLOW_EMPTY:${KERNEL_PACKAGE_NAME}-devicetree = "1"
MACHINE_FEATURES += "efi"
EFI_PROVIDER = ""
WKS_FILE ?= "grub-bootdisk.wks"
QEMU_EXTRAOPTIONS_zen5 = " -cpu EPYC"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto-epyc"
MACHINE_EXTRA_RRECOMMENDS:append = " kernel-modules linux-firmware"
