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

SRC_URI[md5sum] = "cccf38110798a2e20bf9212663332045"
SRC_URI[sha256sum] = "c694a112cd508d9c8fdad1b92bde05e7c48b14d66bad0c3999e443367437e37e"

