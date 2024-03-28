N = int(input())

A = [0] * (N+2)

A[1] = A[2] = 1

for i in range(3, N + 1):
    # 1~N-2
    for j in range(1, i-1):
        A[i] += A[j]
    A[i] += 1
print(A[N])
