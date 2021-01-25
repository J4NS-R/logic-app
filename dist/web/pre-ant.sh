#!/bin/bash

# Set up stuff to prep antpack

set -e

mkdir -p ant-ws

# copy in src webapp stuff
cp -r ../../za.org.cair.logic_app.web/src/main/webapp/ src/main/

# swap /home/runner with real home dir
sed -i -e "s;/home/runner/\\.m2;$HOME/\\.m2;" antpack.xml

cp ../jar-in-jar-loader.zip ./

echo "Done"

