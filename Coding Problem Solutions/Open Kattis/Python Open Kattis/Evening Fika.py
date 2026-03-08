"""
Sara loves fika! She has just received Swedish kronor from her mom to buy some evening fika. Since Sara is smart, she will try to spend the money as wisely as possible. At the store Lugnbyrån, there are pastries available. Each pastry has a certain price and a specific category. Because Sara likes fika so much, she almost thinks all kinds of pastries are equally tasty. Namely, she has no preference for which category of pastry to buy, but she feels it would be a bit too monotonous if she buys more than pastries of the same category.

Help Sara buy as many pastries as possible, with a total cost less than or equal to . Also, ensure that there are no more than pastries from the same category among those she bought. You only need to print out how many pastries she can buy, not which ones.
Input

The first line of the input contains the integer (), the number of pastries Sara can choose from.

The next line contains the integer (), the number of kronor Sara has as a budget for her evening fika.

The next line contains the integer (), the maximum number of pastries from each category that Sara is willing to eat.

The next line contains the integers (), where means that that pastry costs kronor. Note that the total cost of all pastries may not necessarily fit in a 32-bit integer.

The last line contains the integers (). There are exactly categories of pastries, and we refer to each with an integer. Each means that that pastry belongs to category .
Output

Print an integer: the number of pastries that Sara can buy if she uses her budget optimally.
Scoring

Your solution will be tested on a set of test groups, each worth a number of points. Each test group contains a set of test cases. To get the points for a test group you need to solve all test cases in the test group.
"""
pastries = int(input())
budget = int(input())
costs = 