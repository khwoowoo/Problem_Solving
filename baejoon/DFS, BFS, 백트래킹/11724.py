from collections import deque
import sys

input = sys.stdin.readline
n, m = map(int, input().split())
adj = [[] for _ in range(n)]  # 인접 리스트 사용
chk = [False] * n  # 1차원 방문 체크 리스트
result = 0

for _ in range(m):
    y, x = map(int, input().split())
    adj[y - 1].append(x - 1)
    adj[x - 1].append(y - 1)

def bfs(start):
    queue = deque([start])
    chk[start] = True
    while queue:
        now = queue.popleft()
        for nxt in adj[now]:
            if not chk[nxt]:
                chk[nxt] = True
                queue.append(nxt)

for i in range(n):
    if not chk[i]:
        bfs(i)
        result += 1

print(result)
