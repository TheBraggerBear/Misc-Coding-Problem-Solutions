def last2(str):
  add = 0
  last = str[-2:]
  for i in range(len(str)-2):
    if (str[i:i+2]) == last:
      add += 1
  return add