import math
from itertools import combinations


N = int(input())

for _ in range(N):
    A = list(map(int, input().split()))
    B = []
    for i in range(1, A[0] + 1):
        B.append(A[i])
    total = sum(math.gcd(a, b) for a, b in combinations(B, 2))
    print(total)
