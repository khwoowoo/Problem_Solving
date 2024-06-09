# top-down
import sys
sys.setrecursionlimit(10**7)

MOD = 10007
N = int(input())
cache = [0] * 1001
cache[1] = 1
cache[2] = 2
def f(n):
  if cache[n] != 0:
    return cache[n]
  cache[n] = f(n - 1) + f(n - 2)
  cache[n] %= MOD
  return cache[n]

print(f(N))

# bottom-up
import sys
input = sys.stdin.readline

N = int(input())
mem = [0] * (N + 2)

mem[1] = 1
mem[2] = 2


for i in range(3, N + 1):
    mem[i] = mem[i - 1] + mem[i - 2]

print(mem[N] % 10007)
