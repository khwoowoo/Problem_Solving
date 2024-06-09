# 점화식 잘 구했는데 Top-Down 했더니 시간초과 나옴 ㅜ
# 하지만 Bottom-Up으로 하면 잘 됌!

#Top-Down
import sys

sys.setrecursionlimit(10**7)

def f(n):
    A = []
    if mem[n] != -1: return mem[n]
    
    if n % 2 == 0: A.append(f(int(n//2)))
    if n % 3 == 0: A.append(f(int(n//3)))
    
    A.append(f(n-1))
    
    mem[n] = min(A) + 1
    
    return mem[n]


N = int(input())
mem = [-1] * (10**6 + 1)

mem[1] = 0
mem[2] = mem[3] = 1

print(f(N))

#Bottom - Up
N = int(input())
mem = [0] * (N+1)

for i in range(2, N+1):
    mem[i] = mem[i-1] + 1  # 1을 빼는 연산
    
    if i % 2 == 0:
        mem[i] = min(mem[i], mem[i//2] + 1)  # 2로 나누는 연산이 가능한 경우
    if i % 3 == 0:
        mem[i] = min(mem[i], mem[i//3] + 1)  # 3으로 나누는 연산이 가능한 경우

print(mem[N])
