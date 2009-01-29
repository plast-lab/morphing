#!/bin/sh -e

export MJ_ROOT=/home/shuang/workspace
export MJ_FRONT=$MJ_ROOT/MJFrontend
export MJ_EXAMPLES=$MJ_ROOT/examples
export CLASSPATH=$CLASSPATH:$MJ_FRONT/bin

testname=""
testfile=""

if [ $# = 0 ]; then

    echo "******************************************"
    echo "ModifierUnificationTest"
    junit testcases.junit.ModifierUnificationTest
    
    echo "******************************************"
    echo "VectorMatchTest"
    junit testcases.junit.VectorMatchTest
    
    echo "******************************************"
    echo "RangeInternalUniquenessTest"
    junit testcases.junit.RangeInternalUniquenessTest
    
    echo "******************************************"
    echo "UniquenessFromObjectTest"
    junit testcases.junit.UniquenessFromObjectTest
    
    echo "******************************************"
    echo "UniquenesFromVariableSuper"
    junit testcases.junit.UniquenessFromVariableSuper
    
    echo "******************************************"
    echo "Examples"
    junit testcases.junit.ExamplesTest
    
else
    case "$1" in 
	"modifierunification")
	    testname="ModifierUnificationTest"
	    testfile="testcases.junit.ModifierUnificationTest"
	    ;;
	"vectormatch")
	    testname="VectorMatchTest"
	    testfile="testcases.junit.VectorMatchTest"
	    ;;
	"rangeinternalunique")
	    testname="RangeInternalUniquenessTest"
	    testfile="testcases.junit.RangeInternalUniquenessTest"
	    ;;
	"uniquefromobject")
	    testname="UniquenessFromObjectTest"
	    testfile="testcases.junit.UniquenessFromObjectTest"
	    ;;
	"uniquefromvariablesuper")
	    testname="UniquenesFromVariableSuper"
	    testfile="testcases.junit.UniquenessFromVariableSuper"
	    ;;
	"examples")
	    testname="Examples"
	    testfile="testcases.junit.ExamplesTest"
	    ;;
	*)
    esac

    echo "******************************************"
    echo $testname
    junit $testfile
fi