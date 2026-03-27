"""
The ministers of the cabinet were quite upset by the message from the Chief of Security stating that they would all have to change the four-digit room numbers on their offices.
— It is a matter of security to change such things every now and then, to keep the enemy in the dark.
— But look, I have chosen my number 1033 for good reasons. I am the Prime minister, you know!
— I know, so therefore your new number 8179 is also a prime. You will just have to paste four new digits over the four old ones on your office door.
— No, it’s not that simple. Suppose that I change the first digit to an 8, then the number will read 8033 which is not a prime!
— I see, being the prime minister you cannot stand having a non-prime number on your door even for a few seconds.
— Correct! So I must invent a scheme for going from 1033 to 8179 by a path of prime numbers where only one digit is changed from one prime to the next prime.

Now, the minister of finance, who had been eavesdropping, intervened.
— No unnecessary expenditure, please! I happen to know that the price of a digit is one pound.
— Hmm, in that case I need a computer program to minimize the cost. You don’t know some very cheap software gurus, do you?
— In fact, I do. You see, there is this programming contest going on

Help the prime minister to find the cheapest prime path between any two given four-digit primes! The first digit must be nonzero, of course. Here is a solution in the case above.

    1033
    1733     
    3733     
    3739     
    3779
    8779
    8179     

The cost of this solution is pounds. Note that the digit which got pasted over in step can not be reused in the last step – a new must be purchased.
Input

One line with a positive number: the number of test cases (at most 100). Then for each test case, one line with two numbers separated by a blank. Both numbers are four-digit primes (without leading zeros).
Output

One line for each case, either with a number stating the minimal cost or containing the word “Impossible”.
Sample Input 1 	Sample Output 1

3
1033 8179
1373 8017
1033 1033

	

6
7
0

"""
import sys
from collections import deque

def sieve_primes(limit):
    sieve = [True] * (limit+1)
    sieve[0:2] = [False, False]
    for i in range(2, int(limit**0.5)+1):
        if sieve[i]:
            for j in range(i*i, limit+1, i):
                sieve[j] = False
    return sieve

def neighbors(num, is_prime):
    s = list(str(num))
    res = []
    for i in range(4):
        orig = s[i]
        for d in '0123456789':
            if i == 0 and d == '0':
                continue
            if d == orig:
                continue
            s[i] = d
            v = int(''.join(s))
            if is_prime[v]:
                res.append(v)
        s[i] = orig
    return res

def bfs(start, target, is_prime):
    if start == target:
        return 0
    visited = [False] * 10000
    q = deque()
    q.append((start, 0))
    visited[start] = True
    while q:
        cur, dist = q.popleft()
        for nb in neighbors(cur, is_prime):
            if not visited[nb]:
                if nb == target:
                    return dist + 1
                visited[nb] = True
                q.append((nb, dist+1))
    return -1

def main():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    t = int(data[0])
    tokens = data[1:]
    is_prime = sieve_primes(9999)
    out_lines = []
    idx = 0
    for _ in range(t):
        if idx + 1 >= len(tokens):
            break
        start = int(tokens[idx]); target = int(tokens[idx+1]); idx += 2
        dist = bfs(start, target, is_prime)
        out_lines.append(str(dist) if dist >= 0 else "Impossible")
    sys.stdout.write("\n".join(out_lines))

if __name__ == "__main__":
    main()

