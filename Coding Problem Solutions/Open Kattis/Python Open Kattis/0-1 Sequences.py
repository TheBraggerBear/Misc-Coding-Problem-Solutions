'''
You are given a sequence, in the form of a string with characters ‘0’, ‘1’, and ‘?’ only. Suppose there are ‘?’s. Then there are ways to replace each ‘?’ by a ‘0’ or a ‘1’, giving different 0-1 sequences (0-1 sequences are sequences with only zeroes and ones).

For each 0-1 sequence, define its number of inversions as the minimum number of adjacent swaps required to sort the sequence in non-decreasing order. In this problem, the sequence is sorted in non-decreasing order precisely when all the zeroes occur before all the ones. For example, the sequence 11010 has inversions. We can sort it by the following moves: 11010 11001 10101 01101 01011 00111.

Find the sum of the number of inversions of the sequences, modulo ().
Input

The first and only line of input contains the input string, consisting of characters ‘0’, ‘1’, and ‘?’ only, and the input string has between to characters, inclusive.
Output

Output an integer indicating the aforementioned number of inversions modulo .
Sample Input 1 	Sample Output 1

?0?

	

3

'''
import sys

MOD = 1000000007

for raw_line in sys.stdin:
    line = raw_line.strip()
    if not line:
        continue

    # k = total number of '?' in the entire string
    k = line.count("?")
    # pow2[t] = 2^t mod MOD, used for counting assignments of remaining '?'s
    pow2 = [1] * (k + 1)
    for i in range(1, k + 1):
        pow2[i] = (pow2[i - 1] * 2) % MOD

    total = 0
    # Prefix counts: how many of each symbol we've seen to the left so far
    left_ones = 0
    left_q = 0

    for ch in line:
        if ch == "0":
            # Pairs (1,0): left '1' with current '0'
            if left_ones:
                total = (total + left_ones * pow2[k]) % MOD
            # Pairs (?,0): left '?' forced to 1, current '0' fixed
            if left_q and k >= 1:
                total = (total + left_q * pow2[k - 1]) % MOD
        elif ch == "?":
            # Pairs (1,?): current '?' forced to 0
            if left_ones and k >= 1:
                total = (total + left_ones * pow2[k - 1]) % MOD
            # Pairs (?,?): left '?' forced to 1, current '?' forced to 0
            if left_q and k >= 2:
                total = (total + left_q * pow2[k - 2]) % MOD

        if ch == "1":
            left_ones += 1
        elif ch == "?":
            left_q += 1

    print(total % MOD)