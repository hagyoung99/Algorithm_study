import sys
n, m ,r = map(int, sys.stdin.readline().split()) #정점의 수, 간선의 수, 시작 정점
u, v = list(), list() # 정점u, 정점v 가중치 1, 양방향 간선
#정점 번호를 오름차순으로!! 방문
#내림차순 정렬 -> 내림차순 후, 후입선출 전략을 사용하면 오름차순과 같게됨 = 성능 증가
#시작 정점에서 방문할 수 없는 노드는 0!!!

graph =[[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):#2차원배열형태 저장
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(graph, start_node, visited):
    need_visit= list()
    graph[start_node].sort()


result = dfs(graph, r, visited)
for i in result:
    print(i)

