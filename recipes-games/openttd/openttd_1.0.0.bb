DESCRIPTION = "Open source clone of the Microprose game 'Transport Tycoon Deluxe' - SDL edition."
HOMEPAGE = "http://www.openttd.org"
LICENSE = "GPLv2"
DEPENDS = "libsdl-net libpng zlib freetype fontconfig"
RRECOMMENDS_${PN} = "opengfx opensfx"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
PR = "r1"

inherit siteinfo sdl autotools

SRC_URI ="https://cdn.openttd.org/openttd-releases/${PV}/openttd-${PV}-source.tar.bz2 \
	  file://unistd.patch \
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
 --endian=${SITEINFO_ENDIANNESS} \
 --prefix-dir=${prefix} \
 --binary-dir=bin \
 --with-midi=/bin/true \
 --with-zlib=${STAGING_LIBDIR} \
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

SRC_URI[md5sum] = "738c8eac581a4fbd219eae748e5a15ec"
SRC_URI[sha256sum] = "5049e1c5a14e134ed20d8ea9fe781502b5fd9588c1ca80e99f2d061b9927153b"

