M, N = map(int, input().split(' '))
prime = [True for _ in range(N + 1)]
p = 2

prime[0] = prime[1] = False

while p * p <= N:
    if prime[p]:
        for i in range(p*p, N+1, p):
            prime[i] = False
    p += 1
    
for i in range(M, N+1):
    if prime[i]: print(i)

# 에라토스테네스의 체를 이용한 방법을 사용하였음
