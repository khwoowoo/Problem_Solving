N = int(input())
A = list(map(int, input().split()))
R = [0 for _ in range(N)]
stack = []

for i in range(N):
    if len(stack) == 0: 
        stack.append(i)
        continue
    
    while stack and A[i] > A[stack[-1]]:
        R[stack[-1]] = A[i]
        stack.pop()
    
    stack.append(i)
    
while stack:
    R[stack[-1]] = -1
    stack.pop()
    
for i in R:
    print(i, end=' ')

# 무조건 스택을 사용한 방법을 할 것이라고 예상했고
# 시간복잡도는 O(N^2) 보다 작아야 한다고 생각했지만
# 결국 풀지 못 했다...
# 접근하는 방식 완전히 달랐다
# 여러 방법을 찾던 중 나는 스택에 모든 값을 넣어서 접근하려고 했으나
# 스택에 넣으면서 해야되는 거였다.. 
# 나중에 다시 풀어보기 좋은 문제인듯..!
