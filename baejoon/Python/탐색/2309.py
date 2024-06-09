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

# 모범 코드
# 주의 - 조합이 여러 개 나올 수 있으니 꼭 break
from itertools import combinations

heights = [int(input()) for _ in range(9)]

for combi in combinations(heights, 7):
  if sum(combi) == 100:
    for height in sorted(combi):
      print(height)
    break

# 만약 문제에서 combinations을 사용하지 말라고 했을 경우
# 9중 for문 사용. 하지만 너무 심하니 9개의 합에서 2개를 선택해서 빼는 방법 사용
# 반복문에서 종료하는 방법에는 flag, 함수 return, exit() 사용
heights = [int(input()) for _ in range(9)]
heights.sort()
total = sum(heights)

def f():
  for i in range(8):
    for j in range(i + 1, 9):
      if total - heights[i] - heights[j] == 100:
        for k in range(9):
          if k != i and k != j:
            print(heights[k])
        return
f()

    



