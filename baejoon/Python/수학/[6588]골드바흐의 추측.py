import sys

input = sys.stdin.readline

prime = [True for _ in range(1000001)]
p = 2
prime[0] = prime[1] = False

A = []

while p * p <= 1000001:
    if prime[p]:
        for i in range(p*p, 1000001, p):
            prime[i] = False
    p += 1
    
for i in range(1000001):
    if prime[i]: A.append(i)


while True:
    n = int(input())
    isPrint = False
    if n == 0: break
    
    for i in A:
        if n-i == 0: break
        if prime[n-i] and prime[i]:
            isPrint = True
            print('{} = {} + {}'.format(n, i, n-i))
            break
    if isPrint == False: print('Goldbach\'s conjecture is wrong.')

# 소수 문제를 풀기 위해서는 에라토스테네스 체를 사용하는 방법이 좋은 듯!
# 시간이 0.5초라서 처음에는 시간 초가 났음
# 하지만 소수만 존재하는 리스트에 넣어서 리스트 안에 있는 값을 가져오는 방법으로 문제 해결!
