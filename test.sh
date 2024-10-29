#!/bin/bash
clear

n=30 # Number of test cases

# Ask the user for the mode
read -p "[d]efault - just run the test, 
[l]ogging - show the game playing while runing the tests,
[t]iming: - show the time it takes to run the test
Choose mode: " mode
# Ask the user which test they want to run or give the option for all
read -p "Enter the test number to run (1-$n) or type 'all' for running all tests: " choice

# Function to run a single test case
run_test() {
    local i=$1
    local mode=$2
    # Check if both files exist before comparing
    if [[ -f "Tests/TestsIn/test$i.in" && -f "Tests/TestsOut/test$i.out" ]]; then
        # Compile and redirect error stream
        if [[ $mode == "d" ]]; then
            mvn -q exec:java < "Tests/TestsIn/test$i.in" > /dev/null 2> "Tests/Out/$i.out"
        elif [[ $mode == "l" ]]; then
            mvn -q exec:java < "Tests/TestsIn/test$i.in" 2> "Tests/Out/$i.out"
        elif [[ $mode == "t" ]]; then
            time mvn -q exec:java < "Tests/TestsIn/test$i.in" > /dev/null 2> "Tests/Out/$i.out"
        fi
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
    # Validate mode input
    if [[ "$mode" =~ ^(d|l|t)$ ]]; then
        # Loop through files from 0 to n
        for ((i=1; i<=n; i++)); do
            run_test $i $mode
        done
    else
        echo "Invalid mode. Please choose 'd' for default, 'l' for logging, or 't' for timing."
    fi
else
    # Check if user input is within range
    if [[ "$choice" =~ ^[0-9]+$ ]]; then
        # Check if mode input is correct
        if [[ "$mode" =~ ^(d|l|t)$ ]]; then
            run_test $choice $mode
        else
            echo "Invalid mode. Please choose 'd' for default, 'l' for logging, or 't' for timing."
        fi
    else
        echo "Invalid choice. Please enter a number between 1 and $n or 'all' for running all tests."
    fi
fi

