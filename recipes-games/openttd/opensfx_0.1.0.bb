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

SRC_URI[md5sum] = "1a43ee0a2026b7fecfd47c7c7e4b056f"
SRC_URI[sha256sum] = "ea0d90e3e049aec2e0884bc117a46e5fb78411b7e3633b3802d4c5af8f29300c"

