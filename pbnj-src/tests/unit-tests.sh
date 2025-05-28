#! /bin/sh
JAVA_LIB_CLASSES=$PBNJ_HOME/tests/classes
if [ "$1" != "" ];
then
# compiling...
rm $JAVA_LIB_CLASSES/pbnj/awt/Point.class
rm $JAVA_LIB_CLASSES/pbnj/util/ArrayList.class
rm $JAVA_LIB_CLASSES/pbnj/util/Vector.class
rm $JAVA_LIB_CLASSES/pbnj/examples/primitives/*.class
rm -f *.class
#cd ..;ant clobber;$ANT_CMD;cd tests
echo 'compiling classes/pbnj/awt/Point'
./pbnjc -d classes classes/pbnj/awt/Point.pbj
echo 'compiling classes/pbnj/util/ArrayList'
./pbnjc -d classes classes/pbnj/util/ArrayList.pbj
echo 'compiling classes/pbnj/util/Vector'
./pbnjc -d classes classes/pbnj/util/Vector.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJString'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJString.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJInteger'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJInteger.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJFloat'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJFloat.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJLong'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJLong.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJDouble'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJDouble.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJMap'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJMap.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJSet'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJSet.pbj
echo 'compiling classes/pbnj/examples/primitives/PBJUtils'
./pbnjc -d classes classes/pbnj/examples/primitives/PBJUtils.pbj
echo 'compiling IntSqrt'
./pbnjc IntSqrt.pbj
echo 'compiling ArrayTest'
./pbnjc ArrayTest.pbj
echo 'compiling LList'
./pbnjc LList.pbj
echo 'compiling BSTree'
./pbnjc BSTree.pbj
echo 'compiling RBTree'
./pbnjc RBTree.pbj
echo 'compiling Dots'
./pbnjc Dots.pbj
(( i = 1 ))
while [ -f "Test${i}.pbj" ]
do
  echo "compiling Test$i"
  ./pbnjc Test${i}.pbj
  (( i++ ))
done
fi
# running...

./pbnj IntSqrt
./pbnj ArrayTest
./pbnj LList
./pbnj BSTree
./pbnj RBTree
./pbnj Dots
(( i = 1 ))
while [ -f "Test${i}.pbj" ]
do
  echo "running Test$i"
  ./pbnj Test${i}
  (( i++ ))
done

