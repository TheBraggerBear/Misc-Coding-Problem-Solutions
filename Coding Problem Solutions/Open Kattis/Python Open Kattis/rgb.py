"""
While hunting monsters, the brave hunter encounters a Hydra. But this was not just any Hydra - this is an RGB Hydra!

This terrifying creature can have heads of three different colors. Initially, the Hydra has:

    red heads,

    green heads, and

    blue heads.

Each time the hunter cuts off a head of a particular color, two new heads instantly grow back - one of each of the other two colors. For example, if the hunter cuts off a red head, then a green and a blue head will grow back immediately.

Driven by courage and ambition, the hunter not only wants to defeat the Hydra but also leave a lasting trace of the journey. To do this, the hunter wants as much red as possible to be visible on the Hydra - the goal is to maximize the number of red heads!

Before the Hydra launches its attack, the hunter has enough time to make at most moves, where each move involves cutting off a single head.

What is the maximum number of red heads the Hydra can have after at most moves?
Input

The input consists of a single line containing four integers , , , and (), where:

    is the number of red heads,

    is the number of green heads,

    is the number of blue heads,

    is the maximum number of moves the hunter can perform.

It is guaranteed that the Hydra has at least one head initially, i.e., .

(Note that the numbers are very large, and in languages like C++, you will need to use long long instead of int.)
Output

Print a single integer: the maximum number of red heads the Hydra can have after at most moves.
Scoring

Your solution will be tested on a set of test groups, each worth a number of points. Each test group contains a set of test cases. To get the points for a test group you need to solve all test cases in the test group.

Explanation of Samples

The Hydra initially has only 1 blue head, and the hunter can make at most 1 move. The only move that can be made is to cut off the blue head, which results in 1 red head and 1 green head. No more moves can be performed, which means that 1 red head is the maximum number.

The Hydra has 4 red heads, 3 green heads, and 2 blue heads, and the hunter can make at most 1 move. The hunter can, for example, choose to cut off a green head, which results in 5 red heads, 2 green heads, and 3 blue heads. After this move, no further moves can be performed. There is no way to get more than 5 red heads, so the answer is 5.

The Hydra has 10 heads of each color. Since the hunter cannot make any moves, the number of red heads remains 10.
"""
import sys

for i in sys.stdin:
    values = list(map(int, i.split()))
    possible = values[1] + values[2]
    if values[3] == 0:
        print(values[0])
    elif possible == 0:
        if values[3] < 2:
            print(values[0])
        else:
            print(values[0] + values[3] - 2)
    else:
        print(values[0] + values[3])