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

# 모범 코드
#내가 더 복합했던 이유: 파이썬의 기능을 너무 몰랐음. 튜플까지의 접근까지는 동일하였으나, 튜플의 모든 원소들을 고려해서 정렬해주지 몰랐음.
#그래서 나는 더 복잡하게 같은 절대값들의 데이터를 가져와서 정렬하고 출력하고 다시 힙에 넣고 일걸 반복했음
# 로직은 동일한 듯 합니다? 근데 나는 길이 구하는 함수 len()를 사용했는데, 0 보다 작으면 걍 if문에서 안들어감.
# C++ 처럼 해주는지 몰랐네 ㅎㅎ..
# 그리고 빠른 입출력은 그냥 함수포인터? 가능거 사용해서 연속적으로 사용하는 것도 좋은 방법이 있었음
import heapq as hp
import sys

input = sys.stdin.readline
pq = []
for _ in range(int(input())):
  x = int(input())
  if x:
    hp.heappush(pq, (abs(x), x))
  else:
    print(hp.heappop(pq)[1] if pq else 0)
