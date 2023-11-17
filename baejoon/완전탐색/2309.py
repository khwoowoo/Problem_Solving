from itertools import combinations
import sys

input = sys.stdin.readline

heights = []

for _ in range(9):
  heights.append(int(input()))

for comList in list(combinations(heights, 7)):
  sum = 0
  for item in comList:
    sum += item

  if sum == 100:
    for item in sorted(comList):
      print(item)
    break
  

