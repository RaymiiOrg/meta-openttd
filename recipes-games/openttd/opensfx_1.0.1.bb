DESCRIPTION = "Sound files for openttd"
HOMEPAGE = "http://bundles.openttdcoop.org/opensfx/"
LICENSE = "CLOSED"


PACKAGE_ARCH = "all"

SRC_URI = "https://cdn.openttd.org/opensfx-releases/${PV}/opensfx-${PV}-all.zip" 

do_install() {
 install -d ${D}${datadir}/games/openttd/data/
 install -m 0644 ${WORKDIR}/opensfx-${PV}.tar ${D}${datadir}/games/openttd/data/
}

FILES_${PN} = "${datadir}"

SRC_URI[md5sum] = "08797da141f7b0e25f8efcb27093a0d2"
SRC_URI[sha256sum] = "37b825426f1d690960313414423342733520d08916f512f30f7aaf30910a36c5"

