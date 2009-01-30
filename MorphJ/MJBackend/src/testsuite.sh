#!/bin/sh -e

export MJ_ROOT=/home/shuang/workspace
export MJ_BACK=$MJ_ROOT/MJBackend
export MJ_EXAMPLES=$MJ_ROOT/examples
export MJ_JUNIT_DIR=$MJ_BACK/src/testcases/mjunit
export JUNIT_JAR=/home/shuang/lib/eclipse/plugins/org.junit4_4.3.1/junit.jar:

export CLASSPATH=.:$MJ_BACK/thirdparty/asm-all-3.1.jar:$MJ_BACK/bin:$MJ_JUNIT_DIR:$MJ_ROOT

testname=""
testfile=""
mjunit_name=""
mjunit_file=""

if [ $# = 0 ]; then

    echo "******************************************"
    echo "CompileAdderAdderTest"
    junit testcases.junit.CompileAdderAdderTest

    echo "******************************************"
    echo "AdderTest"
    junit testcases.mjunit.AdderTest


    echo "******************************************"
    echo "CompileAdderSeparately"
    junit testcases.junit.CompileAdderSeparately

    echo "******************************************"
    echo "AdderTest"
    junit testcases.mjunit.AdderTest


    echo "******************************************"
    echo "CompileAntiGetterTest"
    junit testcases.junit.CompileAntiGetter

    echo "******************************************"
    echo "AntiGetterTest"
    junit testcases.mjunit.AntiGetterTest


    echo "******************************************"
    echo "CompileAntiGetterSeparately"
    junit testcases.junit.CompileAntiGetterSeparately

    echo "******************************************"
    echo "AntiGetterTest"
    junit testcases.mjunit.AntiGetterTest


    echo "******************************************"
    echo "CompileBooleanExpression"
    junit testcases.junit.CompileBooleanExpression

    echo "******************************************"
    echo "CompileBooleanExpressionSeparately"
    junit testcases.junit.CompileBooleanExpressionSeparately


else
    case "$1" in
	"adder")
	    testname="CompileAdderAdderTest"
	    testfile="testcases.junit.CompileAdderAdderTest"
	    mjunit_name="AdderTest"
	    mjunit_file="testcases.mjunit.AdderTest"
	    ;;
	"adderTest")
	    testname="CompileAdderSeparately"
	    testfile="testcases.junit.CompileAdderSeparately"
	    mjunit_name="AdderTest"
	    mjunit_file="testcases.mjunit.AdderTest"
	    ;;

	"antigetter")
	    testname="CompileAntiGetter"
	    testfile="testcases.junit.CompileAntiGetter"
	    mjunit_name="AntiGetterTest"
	    mjunit_file="testcases.mjunit.AntiGetterTest"
	    ;;

	"antigetterTest")
	    testname="CompileAntiGetterSeparately"
	    testfile="testcases.junit.CompileAntiGetterSeparately"
	    mjunit_name="AntiGetterTest"
	    mjunit_file="testcases.mjunit.AntiGetterTest"
	    ;;

	"booleanexpr")
	    testname="CompileBooleanExpression"
	    testfile="testcases.junit.CompileBooleanExpression"
	    mjunit_name="BooleanExprTest"
	    mjunit_file="testcases.mjunit.BooleanExprTest"
	    ;;

	"booleanexprTest")
	    testname="CompileBooleanExpressionSeparately"
	    testfile="testcases.junit.CompileBooleanExpressionSeparately"
	    mjunit_name="BooleanExprTest"
	    mjunit_file="testcases.mjunit.BooleanExprTest"
	    ;;
    esac

    echo "******************************************"
    echo $testname
    junit $testfile

    echo "******************************************"
    echo $mjunit_name
    junit $mjunit_file
fi

