def string_splosion(str):
  build = ""
  for i in range(len(str)):
    for x in range(i+1):
      build += str[x]
  return build