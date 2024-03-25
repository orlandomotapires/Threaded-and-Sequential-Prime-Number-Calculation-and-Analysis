#!/bin/bash

# Compile Main.java
echo "Starting the compilation!"
sleep 1
javac main.java
echo "Compilation succeeded!" 
sleep 1

# Loop through thread_num and pod values
for thread_num in 1 5 10; do
    echo "Starting the execution with" $thread_num "thread(s)!"
    sleep 1
    for pod in $(seq 1 100); do
        java main $thread_num $pod
    done
    echo $thread_num "thread(s) execution succeeded!"
    sleep 1
done
echo "Execution succeeded!" 
sleep 1

# Run the python_analyses file to create the graph
echo "Starting the graph ploting!" 
sleep 1
python3 python_analyses.py
echo "Graph plot succeeded!" 
sleep 1

# Clear time_analyses.txt file
echo "Cleaning analyses file!" 
sleep 1
> ./txt_files/time_analyses.txt

# Clear the .class files
echo "Cleaning .class files!" 
sleep 1
rm *.class

# Ending .sh file
echo "Finishing .sh file execution! Bye." 
sleep 1