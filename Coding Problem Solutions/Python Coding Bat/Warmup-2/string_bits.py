def string_bits(str):
  build = ""
  for i in range(len(str)):
    if i%2 != 1:
      build += str[i]
  return build