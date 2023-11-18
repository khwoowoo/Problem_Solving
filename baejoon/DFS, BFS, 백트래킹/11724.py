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


# 모범 답안
# 나랑 완전 전 반대의 답안
import sys
sys.setrecursinlimit(10 ** 6)
N, M = map(int, input().split())
adj = [[0] * N for _ in range(N)]
for _ in range(M):
    a, b = map(lambda x: x-1, map(int, input().split()))
    adj[a][b] = adj[b][a] = 1
ans = 0
chk = [False] * N

def dfs(now):
    for nxt in range(N):
        if adj[now][nxt] and not chk[nxt]:
            chk[nxt] = True
            dfs(nxt)


for i in range(m):
    if not chk[i]:
        ans +=1
        chk[i] = True
        dsf(i)
print(ans)
