# sieve_threads

There are many algorithms to check prime numbers:

- Trial Division: This is the most straightforward method. You check whether the number is divisible by any integer from 2 up to the square root of the number. If it's not divisible by any number in this range, it's prime.

- Miller-Rabin Primality Test: This is a probabilistic algorithm that is highly efficient and widely used for large numbers. It repeatedly applies a test that is probabilistically accurate in determining whether a number is prime. It can be adjusted to provide a desired level of certainty.

- AKS Primality Test: This is a deterministic algorithm based on polynomial time complexity. It determines whether a given number is prime in polynomial time, but it's typically less efficient in practice compared to Miller-Rabin for large numbers due to its higher constant factors.

- Solovay-Strassen Primality Test: Another probabilistic algorithm similar to Miller-Rabin but using a different approach.

In this approach, will be used the Trial Division algorithm.
