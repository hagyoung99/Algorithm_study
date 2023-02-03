import sys
# 정점u, 정점v 가중치 1, 양방향 간선
#시작 정점에서 방문할 수 없는 노드는 0!!!
#정점의 수, 간선의 수, 시작 정점
sys.setrecursionlimit(10**9)
n, m, r = map(int, sys.stdin.readline().split())
graph =[[] for _ in range(n+1)]
visited = [0] * (n+1)
count = 1

for _ in range(m):  # 2차원배열형태 저장
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

#정점 번호를 오름차순으로!! 방문
#내림차순 정렬 -> 내림차순 후, 후입선출 전략을 사용하면 오름차순과 같게됨 = 성능 증가
def dfs(v):
    global count
    visited[v] = count
    graph[v].sort(reverse=True)

    for g in graph[v]:
        if visited[g] == 0:
            count += 1
            dfs(g)

dfs(r)

print(*visited[1:], sep="\n")

