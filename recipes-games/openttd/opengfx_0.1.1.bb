DESCRIPTION = "Grafik files for openttd"
HOMEPAGE = "http://bundles.openttdcoop.org/opengfx/"
LICENSE = "CLOSED"

PACKAGE_ARCH = "all"

SRC_URI = "https://cdn.openttd.org/opengfx-releases/${PV}/opengfx-${PV}-all.zip"

do_install() {
 install -d ${D}${datadir}/games/openttd/data/
 install -m 0644 ${WORKDIR}/opengfx-${PV}.tar ${D}${datadir}/games/openttd/data/
}

FILES_${PN} = "${datadir}"

SRC_URI[md5sum] = "1f959407f2d4a1ab0e84c2e89438c922"
SRC_URI[sha256sum] = "c0eefb2dda166f91e1bfb317cf681165029f6f2709fa966d84dc568ffef6a31e"
