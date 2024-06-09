import sys

input = sys.stdin.readline

N, L = map(int, input().split())

position = list(map(int, input().split()))
position.sort()
result = 0
start = 0

for i in range(1, len(position)):
  if (position[i] - position[start]) >= L:
    result += 1
    start = i

if start <= len(position):
  result += 1
print(result)

