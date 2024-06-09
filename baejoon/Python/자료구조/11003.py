from collections import deque
import sys

input = sys.stdin.readline
N, L = map(int, input().split(' '))
q = deque()
A = list(map(int,  input().split(' ')))

for i in range(1, N + 1):
    iNum = A[i - 1]
    
    # 비워있으면 그냥 입력
    if len(q) == 0: 
        q.append((i, iNum))
        print(iNum)
        continue
    
    # 뒤에 값 제거
    end = q.pop()
    if end[1] >= iNum:
        while len(q) != 0 and end[1] >= iNum:
            end = q.pop()
    if end[1] < iNum:
        q.append(end)
    q.append((i, iNum))
    
    # 앞에 값 제거
    if (i - q[0][0]) >= L: q.popleft()
    print(q[0][1])

  # 제일 쉬운 방법은 범위 구해서 정렬하는 방법이 있으나 O(N**2 log n)이 나오기 때문에 안 되기 때문에 기각했고
  # 입력할 때 부터 리스트에 정렬하면서 삽입하는 방법을 사용하려고 했으나 O(N**2)이기 때문에 기각했다
  # 결국 해결 방법을 보고 직접 구현했는데 덱을 사용하는 방법있었다...
  # 접근 방식은 비슷했으나 덱 자료구조를 생각을 못 했다...
  # 결국 O(N)의 시간복잡도를 가진다
  # 아래는 모범 코드. 나는 파이썬 언어를 잘 몰라서 복잡한 코드를 작성한듯..!

from collections import deque
import sys

input = sys.stdin.readline
N, L = map(int, input().split(' '))
mydeque = deque()
now = list(map(int,  input().split(' ')))

for i in range(N):
    while mydeque and mydeque[-1][0] > now[i]:
        mydeque.pop()
    mydeque.append((now[i], i))
    
    if mydeque[0][1] <= i - L:
        mydeque.popleft()
    print(mydeque[0][0], end=' ')

