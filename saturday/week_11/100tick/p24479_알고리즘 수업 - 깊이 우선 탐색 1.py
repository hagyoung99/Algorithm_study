import sys

# 빠른 입출력
input = sys.stdin.readline
# 재귀 호출 가능 횟수 증가(1000000000)
sys.setrecursionlimit(10 ** 9)

# N = 정점 수
# M = 간선 수
# R = 시작 노드
N, M, R = map(int, input().split())

# 깊은 복사로 N개의 정점 빈 배열로 초기화
GRAPH = [[] for _ in range(N + 1)]
# N개의 정점에 대한 방문 순서 기록
# 0인 경우 미방문
VISITED = [0] * (N + 1)

# 누적 방문 순서
cnt = 1

# GRAPH 초기화
for _ in range(M):
    a, b = map(int, input().split())
    GRAPH[a].append(b)
    GRAPH[b].append(a)


def dfs(v):
    # 방문 순서 기록
    global cnt
    VISITED[v] = cnt
    cnt += 1

    # 1번 노드가 [4,2,3]과 연결되어 있다면
    # [2,3,4] 순으로 방문하도록 정렬
    for to in sorted(GRAPH[v]):
        # 방문 순서가 0인 경우, 미방문이므로 재귀 함수 호출
        if VISITED[to] == 0:
            dfs(to)


dfs(R)

# 각 라인에 배열 요소 출력
print(*VISITED[1:], sep="\n")
