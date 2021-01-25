#!/bin/bash

# Set up stuff to prep antpack

set -e

mkdir -p ant-ws

# swap /home/runner with real home dir
sed -i -e "s;/home/runner/\\.m2;$HOME/\\.m2;" antpack.xml

cp ../jar-in-jar-loader.zip ./

# Get xtext web dependencies
curl https://lfs.singularity.net.za/cair/xtext-webjars.tar.xz | tar -xJ

# The content of the above tar can be retrieved by mirroring the webjars of a running dev server:
# wget --mirror --reject='*.html*,style.css,jetty-dir.css' --reject-regex '.*ace.*demo.*' -nH -P src/main/webapp/ http://localhost:8003/{xtext,webjars}/
# I wish there was an easier way.

# copy in src webapp stuff
cp -r ../../za.org.cair.logic_app.web/src/main/webapp/ src/main/

echo "Done!"

