from collections import deque

N, M = map(int, input().split())
adj = [[False] * M for _ in range(N)]
chk = [[False] * M for _ in range(N)]

moveX = (0, 0, -1, 1)
moveY = (-1, 1, 0, 0)

for i in range(N):
    coords = input()
    for j in range(M):
        adj[i][j] = coords[j] == '1'

def checking(y, x):
    return 0 <= y < N and 0 <= x < M

def bfs(y, x):
    queue = deque([(y, x, 1)])  # 거리 정보 추가
    chk[y][x] = True

    while queue:
        y, x, dist = queue.popleft()

        if y == N - 1 and x == M - 1:
            return dist  # 도착 지점에 도달하면 거리 반환

        for i in range(4):
            curY = y + moveY[i]
            curX = x + moveX[i]

            if checking(curY, curX) and not chk[curY][curX] and adj[curY][curX]:
                chk[curY][curX] = True
                queue.append((curY, curX, dist + 1))

    return -1  # 도착 지점에 도달할 수 없는 경우

print(bfs(0, 0))
