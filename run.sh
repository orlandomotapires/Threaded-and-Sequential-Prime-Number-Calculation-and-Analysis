#!/bin/bash

# Compile Main.java
echo("Starting the compilation")
sleep(1)
javac main.java
echo("Compilation Success")
sleep(1)
# Clear time_analyses.txt file
> ./txt_files/time_analyses.txt
# Loop through thread_num and pod values
for thread_num in 1 5 10; do
    for pod in $(seq 1 100); do
        java main $thread_num $pod
    done
done

# Run the python_analyses file to create the graph
python3 python_analyses.py
