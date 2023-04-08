from collections import deque
import itertools

DY = (-1, 1, 0, 0)
DX = (0, 0, -1, 1)

M, N = map(int, input().split())
# 2차원 그래프(토마토 창고)
# 익은 토마토     = 1
# 익지 않은 토마토 = 0
# 없음          = -1


GRF = [list(map(int, input().split()))for _ in range(N)]

# 익은 토마토는 상하좌우에 위치한 '익지 않은 토마토'를 익게 만듬
# '없음'의 경우 '모두 익은 토마토인가'라는 질문의 대상에 포함 되지 않지만,
# 벽처럼 '익은 토마토'와 '익지 않은 토마토' 사이를 가로 막아서
# '익지 않은 토마토'를 고립시켜, 일부 토마토를 익지 못하게 만드는 경우 존재


def getRipeTomatosDeque():
    dq = deque([])

    # GRF의 좌표 상 '익은 토마토'인 경우(1)
    # DEQUE에 추가
    # 이 좌표의 네 방향에 위치한 '안 익은 토마토'를 익힐 것
    for y in range(N):
        for x in range(M):
            if GRF[y][x] == 1:
                dq.append([y, x])

    return dq


def bfs():
    global ANS
    # 최초에 '익은 토마토'가 위치한 좌표가 담긴 deque
    dq = getRipeTomatosDeque()

    while dq:
        y, x = dq.popleft()
        for i in range(4):
            nx = x + DX[i]
            ny = y + DY[i]

            # GRF가 좌표에서 벗어난 경우 통과
            if nx < 0 or nx > M-1 or ny < 0 or ny > N-1:
                continue
            # 0이 아닌 경우,
            # 1. 이미 익은 토마토
            # 2. 빈 공간(-1)
            # 이므로 통과
            if GRF[ny][nx] != 0:
                continue
            # 1 이상의 값은 익은 토마토로 간주하고,
            # 각 좌표에 저장할 값을 익는데 걸린 일수 + 1로 함
            # 시작이 1이기 때문에 걸린 일수 + 1이 되는 것
            GRF[ny][nx] = GRF[y][x] + 1
            dq.append([ny, nx])

bfs()
# 1. 토마토가 모두 익지는 못하는 상태면 -1 출력
flat = list(itertools.chain.from_iterable(GRF))
if flat.count(0) > 0:
    print(-1)
# 2. 그 외, 걸린 일수 출력
else:
    print(max(flat)-1)
