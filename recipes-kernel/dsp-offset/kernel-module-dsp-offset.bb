DESCRIPTION = "DSP to Linux clock offset"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM="file://COPYING;md5=8bb892da51158227971b1033349ee7d8"

inherit module

PR = "r0"
SRC_URI = "file://COPYING \
           file://Makefile \
           file://dsp-offset.c "
S = "${WORKDIR}"

do_module_signing() {
    if [ -f ${STAGING_KERNEL_BUILDDIR}/signing_key.priv ]; then
	${STAGING_KERNEL_DIR}/scripts/sign-file sha512 ${STAGING_KERNEL_BUILDDIR}/signing_key.priv ${STAGING_KERNEL_BUILDDIR}/signing_key.x509 ${PKGDEST}/${PN}/${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/dsp/dsp-offset.ko
    fi
}

addtask module_signing after do_package before do_package_write_ipk