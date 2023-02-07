import sys
from collections import deque
input = sys.stdin.readline

n, m ,r = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
cnt = 1

# 간선 정보 입력받기
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(v):
    global cnt
    q = deque([r])
    # 현재 노드 방문 처리
    visited[r] = cnt
    while q:
        v = q.popleft()
        graph[v].sort(reverse=True)
        # 큐에서 뽑은 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for g in graph[v]:
            if visited[g] == 0:
                cnt += 1
                q.append(g)
                visited[g] = cnt
bfs(r)
for i in range(1, n + 1):
    print(visited[i])