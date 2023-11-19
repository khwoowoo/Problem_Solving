N, M = map(int, input().split())
boards = [input() for _ in range(N)]
candidates = []

def check(y, x, start_color):
    count = 0
    curColor = start_color
    for i in range(8):
        for j in range(8):
            if (curColor and boards[y + i][x + j] != 'W') or (not curColor and boards[y + i][x + j] != 'B'):
                count += 1
            curColor = not curColor
        curColor = not curColor
    return count

for i in range(N - 7):
    for j in range(M - 7):
        candidates.append(check(i, j, True))  # 체스판이 흰색으로 시작하는 경우
        candidates.append(check(i, j, False))  # 체스판이 검은색으로 시작하는 경우

print(min(candidates))
