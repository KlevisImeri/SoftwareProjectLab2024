#!/bin/bash

clear
# mvn exec:java 
mvn -q exec:java < Tests/TestsIn/test18.in
# mvn -q exec:java < Tests/TestsIn/test0.in 2> Tests/Out/out0.out
# diff Tests/Out/out0.out Tests/TestsOut/test0.out