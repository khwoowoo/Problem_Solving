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
