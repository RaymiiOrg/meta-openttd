DESCRIPTION = "Open source clone of the Microprose game 'Transport Tycoon Deluxe' - SDL edition."
HOMEPAGE = "http://www.openttd.org"
LICENSE = "GPLv2"
DEPENDS = "libsdl-net libpng zlib freetype fontconfig"
RRECOMMENDS_${PN} = "opengfx opensfx"
LIC_FILES_CHKSUM = "file://COPYING;md5=c8e1bf7258db0e87b041ef1cb29329f6"
PR = "r1"

inherit siteinfo sdl autotools

SRC_URI ="https://cdn.openttd.org/openttd-releases/${PV}/openttd-${PV}-source.tar.gz \
"
SRC_URI_append_shr = " file://openttd.cfg"

do_configure() {
  # The way the OTTD configure system handles the application's directories
  # isn't the way autotools does it. Mainly prefix is always prepended even if
  # absolute binary-dir and data-dir is given.

  ${S}/configure \
 --host=${TARGET_SYS} \
 --windres=800x600 \
 --os=UNIX \
 --prefix-dir=${prefix} \
 --binary-dir=bin \
 --with-midi=/bin/true \
 --with-zlib \
 --with-png \
 --with-freetype \
 --without-icu \
 --without-allegro \
 --cc-build=gcc \
 --cc-host=${TARGET_SYS}-gcc \
 --cxx-build=g++ \
 --cxx-host=${TARGET_SYS}-g++ \
 --strip=${TARGET_SYS}-strip \
 --install-dir=${D}
}

do_install() {
 oe_runmake install
}


do_install_append_shr() {
 install -d ${D}${datadir}/games/openttd/data/
 install -m 0644 ${WORKDIR}/openttd.cfg ${D}${datadir}/games/openttd/data/
}

FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "1a9164107ba68f593ea6746aa66a1ef0"
SRC_URI[sha256sum] = "b74fc197d3da2c4c696905b8652ad626866d8d8c0c64745d7d660410acbdb2a6"

