from collections import Counter

n, m = map(int, input().split())
a = list(map(int, input().split()))
s = [0] 
result = 0

for i in range(n):
    s.append((s[-1] + a[i]) % m) 

s = Counter(s) 

for count in s.values(): 
    if count >= 2:
        result += count * (count - 1) // 2  

print(result)

# 구하는 방법은 간단하지만 빠른 방법을 구하는 것은 너무어렵다..
# 이 알고리즘 문제는 누적합과 모듈러 연산의 특징을 통해 구간합에 방법을 도출해야 하는데
# 너무 어렵다... 해설 못 봤으면 한 달정도 걸릴 수도? ...오바인가?
# 이건 나중에 다시 풀어보는게 좋을 듯!
