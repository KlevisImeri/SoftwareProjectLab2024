#!/bin/bash
clear

n=30 # Number of test cases

# Ask the user which test they want to run or give the option for all
read -p "Enter the test number to run (1-$n) or type 'all' for running all tests: " choice

# Function to run a single test case
run_test() {
    local i=$1
    # Check if both files exist before comparing
    if [[ -f "Tests/TestsIn/test$i.in" && -f "Tests/TestsOut/test$i.out" ]]; then
        # Compile and redirect error stream
        mvn -q exec:java < "Tests/TestsIn/test$i.in" 2> "Tests/Out/$i.out"
        # Compare files using diff
        if diff -b -Z -B "Tests/Out/$i.out" "Tests/TestsOut/test$i.out"; then
            echo -e "\e[32mTest $i passed\e[0m"  # Output "Test passed" in green
        else
            echo -e "\e[31mTest $i failed\e[0m"  # Output "Test failed" in red
        fi
    else
        echo "Files for test $i not found"
    fi
}

# Run tests based on user choice
if [[ "$choice" == "all" ]]; then
    # Loop through files from 0 to n
    for ((i=1; i<=n; i++)); do
        run_test $i
    done
else
    # Check if user input is within range
    if [[ "$choice" =~ ^[0-$n]+$ ]]; then
        run_test $choice
    else
        echo "Invalid choice. Please enter a number between 1 and $n or 'all' for running all tests."
    fi
fi

