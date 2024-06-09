from collections import Counter

N = int(input())
A = list(map(int, input().split(' ')))
result = [-1] * N
stack = []
counter = Counter(A)

for i in range(N):
    while stack and counter[A[stack[-1]]] < counter[A[i]]:
        result[stack.pop()] = A[i]
    stack.append(i)

print(' '.join(map(str, result)))
