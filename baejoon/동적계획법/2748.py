memo = dict()

def fibo(n):
  if n <= 1:
    return n

  if n in memo.keys():
    return memo[n]
  else:
    memo[n] = fibo(n-1) + fibo(n-2)
    return memo[n]

print(fibo(int(input())))


# 모범 답안 - 재귀 사용
cache = [-1] * 91
cache[0] = 0
cache[1] = 1

def f(n):
  if cache[n] == -1:
    cache[n] = f(n - 1) + f(n - 2)
  return cache[n]

print(f(int(input())))

# 모범 답안 - 반복문 사용
N = int(input())
cache = [-1] * 91
cache[0] = 0
cache[1] = 1

for i in range(2, N + 1)
  cache[i] = cache[i - 2] + cache[i - 1]

print(cache[N])
