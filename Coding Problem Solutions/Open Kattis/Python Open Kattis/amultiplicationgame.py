"""
Stan and Ollie play the game of multiplication by multiplying an integer by one of the numbers to . Stan always starts with , does his multiplication, then Ollie multiplies the number, then Stan and so on. Before a game starts, they draw an integer and the winner is who first reaches .
Input

Each line of input contains the integer . There are at most lines of input.
Output

For each line of input output one line either

Stan wins.

or

Ollie wins.

assuming that both of them play perfectly.
"""

import sys
def switch(n):
    return 9 if n==2 else 2

for line in sys.stdin:
    target = int(line)
    counter = 2
    current = 1
    while current < target:
        counter = switch(counter)
        current *= counter
    if counter == 2:
        print("Ollie wins.")
    else:
        print("Stan wins.")