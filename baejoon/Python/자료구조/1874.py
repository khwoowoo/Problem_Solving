import sys

input = sys.stdin.readline

N = int(input())
A = [int(input()) for _ in range(N)]  # 리스트 컴프리헨션 사용
stack = []
result = []
idx = 0

for i in range(1, N + 1):
    stack.append(i)
    result.append('+')

    # 스택의 마지막 요소가 A[idx]와 같지 않을 때까지 반복
    while stack and stack[-1] == A[idx]:
        stack.pop()
        result.append('-')
        idx += 1

# 스택이 비어있는지 확인
if not stack:
    print('\n'.join(result))  # 결과를 한 번에 출력
else:
    print("NO")
