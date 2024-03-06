N = int(input())
A = list(map(int, input().split()))

A = sorted(A)
total = 0
result = 0

for i in A:
    total += i
    result += total
    
print(result)
