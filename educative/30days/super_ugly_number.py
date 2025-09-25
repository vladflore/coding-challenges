def nth_super_ugly_number(n, primes):
    '''
    Given an integer n and an array of distinct prime numbers primes, return the n-th super ugly number. A super ugly number is a positive integer whose only prime factors are from a given array primes.
    '''
    ugly = [1] * n
    k = len(primes)
    pointers = [0] * k
    candidates = primes[:]
    
    for i in range(1, n):
        next_val = min(candidates)
        ugly[i] = next_val
        
        for j in range(k):
            if candidates[j] == next_val:
                pointers[j] += 1
                candidates[j] = primes[j] * ugly[pointers[j]]
    
    return ugly[-1]
