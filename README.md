# Threaded and Sequential Prime Number Calculation and Analysis

This project involves the multi-threaded calculation of prime numbers from an input file and the analysis of each thread's performance. Three main files are used for this project:

`Main.java:` This file coordinates the multi-threaded prime number calculation and handles the file I/O operations. It utilizes Java's Thread class to spawn multiple threads, each responsible for processing a portion of the input file. After the calculation, it writes the prime numbers found by each thread to the output file (Prime_numbers.txt) and records the time taken by each thread in the time_analyses.txt file.

`MyRunnable.java:` This file contains the implementation of the MyRunnable class, which represents the task performed by each thread. Each thread reads a portion of the input file, checks for prime numbers using the trial division algorithm, and records the elapsed time for processing a subset of lines. The elapsed time for each subset of lines is then written to the time_analyses.txt file.

`Trial_division_algorithm:` This file contains the implementation of the trial division algorithm, which is used by each thread to check whether a number is prime.

### There are many algorithms to check prime numbers

- Trial Division: This is the most straightforward method. You check whether the number is divisible by any integer from 2 up to the square root of the number. If it's not divisible by any number in this range, it's prime.

- Miller-Rabin Primality Test: This is a probabilistic algorithm that is highly efficient and widely used for large numbers. It repeatedly applies a test that is probabilistically accurate in determining whether a number is prime. It can be adjusted to provide a desired level of certainty.

- AKS Primality Test: This is a deterministic algorithm based on polynomial time complexity. It determines whether a given number is prime in polynomial time, but it's typically less efficient in practice compared to Miller-Rabin for large numbers due to its higher constant factors.

- Solovay-Strassen Primality Test: Another probabilistic algorithm similar to Miller-Rabin but using a different approach.

In this approach, will be used the <b>*Trial Division algorithm.*</b>

## Implementation Details

`Main.java:`

Reads the input file to determine the number of lines.
Spawns multiple threads, dividing the workload evenly among them.
Each thread processes a portion of the input file, checking for prime numbers.
After processing, each thread writes the prime numbers found to the output file and records its processing time.
Utilizes synchronization to ensure safe writing to the time_analyses.txt file.

`MyRunnable.java:`

Represents the task performed by each thread.
Reads a portion of the input file and checks for prime numbers.
Records the elapsed time for processing a subset of lines and writes it to the time_analyses.txt file.
Utilizes the trial division algorithm to determine prime numbers.

`Trial_division_algorithm:`

Contains the implementation of the trial division algorithm, a simple method for checking the primality of a number.
The project aims to demonstrate the efficiency of multi-threading in prime number calculation and provides insights into the performance of individual threads through time analysis. The use of multiple threads allows for parallel processing, reducing the overall computation time compared to a single-threaded approach.

## Time analyses

### 1 Thread (Sequential)

Using 1 thread the time spent since the moment of building the threads and starting it until all the thread(s) finish their work took ***0.000670609*** seconds.

### 5 Threads (Parallel)

Using 5 threads the time spent since the moment of building the threads and starting it until all the thread(s) finish their work took ***0.001135529*** seconds.

### 10 Threads (Parallel)

Using 10 threads the time spent since the moment of building the threads and starting it until all the thread(s) finish their work took ***0.001596632*** seconds.

## Conclusions

It was determined that the time invested in creating and managing threads for the parallel approach did not yield significant improvements over the sequential approach. This indicates that the problem at hand is not sufficiently large to justify the overhead of parallelization. Therefore, the sequential approach remains sufficient for solving the problem, and there is no need to parallelize it.
