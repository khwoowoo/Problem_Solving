times, money = map(int, input().split())

tempList = []
result = 0

for _ in range(times):
  tempList.append(int(input()))

for item in sorted(tempList, reverse=True):
  if item <= money:
    result += money // item
    money %= item
print(result)
