#!/bin/bash

clear
# mvn exec:java 
# mvn -q exec:java < Tests/TestsIn/test1.in
# mvn -q exec:java < Tests/TestsIn/test0.in 2> Tests/Out/out0.out
# diff Tests/Out/out0.out Tests/TestsOut/test0.out


# Loop through files from 0 to 1
for i in {0..2}; do
    # Check if both files exist before comparing
    if [[ -f "Tests/TestsIn/test$i.in" && -f "Tests/TestsOut/test$i.out" ]]; then
        # Compile and redirect error stream
        mvn -q exec:java < "Tests/TestsIn/test$i.in" > /dev/null  2> "Tests/Out/$i.out"
        # Compare files using diff
        if diff -b -Z -B "Tests/Out/$i.out" "Tests/TestsOut/test$i.out"; then
            echo -e "\e[32mTest $i passed\e[0m"  # Output "Test passed" in green
        else
            echo -e "\e[31mTest $i failed\e[0m"  # Output "Test failed" in red
        fi
    else
        echo "Files for test $i not found"
    fi
done
