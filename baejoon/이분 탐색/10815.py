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
