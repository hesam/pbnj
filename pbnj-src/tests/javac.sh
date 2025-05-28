JAVA_LIB_CLASSES=$PBNJ_HOME/tests/classes
SOLVERDIR=$PBNJ_HOME/lib/solver
CURRDIR=`pwd`
javac -cp $PBNJ_HOME/classes:$JAVA_LIB_CLASSES:$SOLVERDIR/kodkod/jar/kodkod.jar:$CURRDIR:$PBNJ_CLASSPATH $@
