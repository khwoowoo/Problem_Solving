from bisect import bisect_left

N = int(input())
cards = list(map(int, input().split()))
M = int(input())
targets = list(map(int, input().split()))
answer = [0] * M  # 수정된 크기

cards.sort()

for i in range(M):
    index = bisect_left(cards, targets[i])
    if index < len(cards) and cards[index] == targets[i]:  # IndexError 방지
        answer[i] = 1

print(' '.join(map(str, answer)))  # 간단한 출력

# 모범 답안
from bisect import bisect_left, bisect_right
N = int(input())
cards = sorted(map(int, input().split()))
M = int(input())
qry = list(map(int, input().split()))
ans = []

for q in qry:
    l = bisect_left(cards, q)
    r = bisect_right(cards, q)
    ans.append(i if r - l else 0)

print(*ans)
#print(' '.join(map(str, aswer)))
