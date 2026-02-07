"""
You and Jon are competing in who can write code with the fewest lines as possible. You just realised that the measure used to determine the winner is not who has the fewest characters, but rather the fewest lines. Thus you decide to cram all your code into a single line. However, that is a lot of code so you decide to write a program to concatenate the lines for you.
Input

The input consists of two lines. The first line contains the string . The second line contains the string . Neither line is empty. Only alphabetical letters, digits and the symbols , and r2 will appear in each of the lines.
Output

A line with and concatenated.
"""
import sys
x = []
for line in sys.stdin:
    x.append(line.rstrip())
print("".join(i for i in x))