#!/bin/sh -e

export MJ_FRONT=/home/shuang/workspace/MJFrontend
export CLASSPATH=$CLASSPATH:$MJ_FRONT/bin

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
