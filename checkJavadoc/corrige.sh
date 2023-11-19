#!/bin/bash

ANT=./lib/apache-ant-1.9.6/bin/ant

function checkdoc {
  list=$(find src -name "*.java"); 
  java -cp checkstyle/checkstyle-9.3-all.jar com.puppycrawl.tools.checkstyle.Main -c checkstyle/sun_checks.xml $list 2> errores_javadoc.txt 1>&2
}


if [ $# -ne 1 ]; then
	echo "Falta el nombre del fichero .tgz"
	exit 1
fi

rm -rf src anterror errores_javadoc.txt 2> /dev/null
mkdir -p src 2> /dev/null
cp $1 src/practica.tgz
cd src
tar xvzf practica.tgz
cd ..
if test -d src/es ; then
 export ANT_OPTS="-Xms256m -Xmx1024m"
 echo
# echo "--- Auditoria de tu documentación ---"
 checkdoc
 grep -f checkstyle/exceptions.txt -v  errores_javadoc.txt
# echo "--- Fin auditoria ---"
else
 echo "Error descomprimiendo .tgz"
fi

