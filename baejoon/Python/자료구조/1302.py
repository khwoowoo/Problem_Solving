from collections import Counter
import sys

input = sys.stdin.readline
title = []

for _ in range(int(input())):
  title.append(input())

if len(title) == 1:
  print(title[0])
else:
  counter = dict(Counter(title))
  bestCount = max(counter.values())
  bestBook = []
  
  for key in counter:
    if counter[key] == bestCount:
      bestBook.append(key)

  print(sorted(bestBook)[0])
