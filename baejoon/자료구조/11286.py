# 무주건 빠른 입출력 추천
# 빠른 입력 안 하고 했는데 시간초과
# 하니깐 개 빠르게 채점하고 완료..!

import heapq
import sys

pq = []
times = int(sys.stdin.readline().rstrip())

for _ in range(times):
  data = int(sys.stdin.readline().rstrip())

  if data != 0:
    heapq.heappush(pq, (abs(data), data))
  else:
    if len(pq) == 0:
      print('0')
    elif len(pq) == 1:
      print(heapq.heappop(pq)[1])
    else:
      tempList = []
      curItem = heapq.heappop(pq)
      absData = curItem[0]
      tempList.append(curItem)
      while len(pq) > 1:
        tempData = heapq.heappop(pq)
        if tempData[0] == absData:
          tempList.append(tempData)
        else:
          heapq.heappush(pq, tempData)
          break

      if len(tempList) > 1:
        result = sorted(tempList, key=(lambda x: x[1]))
        print(result[0][1])
        for i in range(1, len(result)):
          heapq.heappush(pq, result[i])
      else:
        print(tempList[0][1])
    
