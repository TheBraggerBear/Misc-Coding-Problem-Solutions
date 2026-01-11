'''
Given a non-empty string like "Code" return a string like "CCoCodCode".

string_splosion('Code') → 'CCoCodCode'
string_splosion('abc') → 'aababc'
string_splosion('ab') → 'aab'
'''
def string_splosion(str):
  build = ""
  for i in range(len(str)):
    for x in range(i+1):
      build += str[x]
  return build