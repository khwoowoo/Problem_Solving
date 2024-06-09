import sys
from collections import deque

# 문자열을 읽어 왼쪽 덱으로 변환
left_deque = deque(sys.stdin.readline().rstrip())
# 오른쪽 덱은 초기에 비어 있음
right_deque = deque()
N = int(sys.stdin.readline().rstrip())

for _ in range(N):
    command = sys.stdin.readline().rstrip()

    if command[0] == 'L' and left_deque:  # 커서를 왼쪽으로 이동
        right_deque.appendleft(left_deque.pop())
    elif command[0] == 'D' and right_deque:  # 커서를 오른쪽으로 이동
        left_deque.append(right_deque.popleft())
    elif command[0] == 'B' and left_deque:  # 왼쪽 문자 삭제
        left_deque.pop()
    elif command[0] == 'P':  # 문자 추가
        left_deque.append(command[2])

# 최종 문자열 생성
result = ''.join(left_deque) + ''.join(right_deque)
print(result)

# 리스트 먼저 풀고 시간초과 때문에 지피티한테 물어본건데
# 덱을 사용할 생각일 1도 못했습니다 ㅜㅜ
# 덱을 두 번 사용할 생각을 하다니...
# 덱을 생각 못 한건 아닌데 중간 삽입 때문에
# 리스트 사용한건데,,,오늘도 반성 또 반성
