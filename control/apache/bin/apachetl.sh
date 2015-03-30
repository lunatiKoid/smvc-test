#!/bin/bash

cd /Users/liang/coding/smvc-test/control/apache/webapps
echo '/Users/liang/coding/smvc-test/control/apache/webapps'
rm -rf *
ls
cd /Users/liang/coding/smvc-test/control/apache/works
rm -rf *
ls
export CATALINA_BASE="/Users/liang/coding/smvc-test/control/apache"
sh /usr/local/homebrew/Cellar/tomcat/apache-tomcat-6.0.43/bin/catalina.sh $@

echo $@
echo $CATALINA_BASE


