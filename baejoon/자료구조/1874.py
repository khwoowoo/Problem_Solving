import sys

input = sys.stdin.readline

N = int(input())
A = []
stack = []
idx = 0
i = 1
result = []

for _ in range(N):
    A.append(int(input()))
    
for i in range(1, N + 1):
    stack.append(i)
    result.append('+')
    
    while stack:
        if stack[-1] == A[idx]:
            stack.pop()
            idx += 1
            result.append('-')
        else: break

while stack:
    if stack[-1] == A[idx]:
        stack.pop()
        result.append('-')
        idx += 1
    else: break


if len(stack) == 0:
    for i in result: print(i)
else:
    print("NO")
