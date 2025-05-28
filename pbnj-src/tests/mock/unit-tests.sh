#! /bin/sh
export PBNJ_CLASSPATH=$PBNJ_HOME/tests:$PBNJ_HOME/tests/mock/jdbc:$PBNJ_HOME/tests/mock/jdbc/antlr-runtime-3.1.1.jar
#rm -f */*.class
if [ "$1" != "" ];
then

# compiling...

echo 'compiling Addressbook'
cd addressbook
pbnjc AddressBook.pbj
cd ..
echo 'compiling Max'
cd max
pbnjc Max.pbj
cd ..
echo 'compiling SomeSet'
cd someset
pbnjc SomeSet.pbj
cd ..
echo 'compiling Birt1'
cd birt
pbnjc Birt1.pbj
cd ..
echo 'compiling Jdbc'
cd jdbc
pbnjc Jdbc.pbj
cd ..
echo 'compiling Birt2'
cd birt
pbnjc Birt2.pbj
cd ..
fi
# running...

echo 'running Addressbook'
cd addressbook
pbnj AddressBook 
cd ..
echo 'running Max'
cd max
pbnj Max
cd ..
echo 'running SomeSet'
cd someset
pbnj SomeSet
cd ..
echo 'running Birt1'
cd birt
pbnj Birt1
cd ..
echo 'running Jdbc'
cd jdbc
pbnj Jdbc
cd ..
echo 'running Birt2'
cd birt
pbnj Birt2
cd ..
