'''
Given 3 int values, a b c, return their sum. 
However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. 
So for example, if b is 13, then both b and c do not count.

lucky_sum(1, 2, 3) → 6
lucky_sum(1, 2, 13) → 3
lucky_sum(1, 13, 3) → 1
'''
def lucky_sum(a, b, c):
  arr = [a,b,c]
  if 13 in arr:
    x = 0
    for i in range(len(arr)):
      if arr[i] == 13:
        break
      else:
        x += arr[i]
    return x
  return sum(arr)
