obj-m := andordrvlx.o
andordrvlx-objs := ioctl.o amcc.o andor.o drvmain.o andor_isr.o vmops.o pld.o

KDIR		:= /lib/modules/$(shell uname -r)/build
PWD		:= $(shell pwd)

default:
	$(MAKE) -C $(KDIR) M=$(PWD)

modules_install:
	$(MAKE) -C $(KDIR) M=$(PWD) modules_install

clean:
	rm -rf *.o *.ko *.mod.* .*.cmd
