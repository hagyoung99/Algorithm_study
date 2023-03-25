from itertools import combinations
import sys

ANS = sys.maxsize

N = int(input())
DY = [0, 0, -1, 1]
DX = [1, -1, 0, 0]


def bfs(coords):
    # ANS는 마지막에 출력할 최소 총 비용.
    # 전역 변수 변경이 일어나기 때문에 global keyword 추가
    global ANS

    # 꽃잎이 겹치는 부분을 visited로 체크
    visited = []

    # 이번 회차의 총 비용(칸 당 비용의 합)
    cost = 0

    # 3개의 좌표를 돌며 반복 작업
    for y, x in coords:
        visited.append((y, x))
        cost += GRF[y][x]

        # 인접한 4칸이 이미 visited인지 확인(꽃잎이 닿는지 여부)
        for i in range(4):
            ny = DY[i] + y
            nx = DX[i] + x

            # 닿는 경우 종료
            if (ny, nx) in visited:
                return

            # 안 닿는 경우 visited에 추가, 비용도 추가
            visited.append((ny, nx))
            cost += GRF[ny][nx]

        # 좌표 3개를 아우르는 총 비용
    # 최소 비용이면 ANS를 cost로 갱신
    ANS = min(cost, ANS)


# 2차원 배열로 입력된 좌표
# [1, 0, 2, 3, 3, 4]
# [1, 1, 1, 1, 1, 1]
# [0, 0, 1, 1, 1, 1]
# [3, 9, 9, 0, 1, 99]
# [9, 11, 3, 1, 0, 3]
# [12, 3, 0, 0, 0, 1]
GRF = [list(map(int, input().split())) for _ in range(N)]
# 입력된 좌표에서 가능한 모든 시작 좌표를 1차원 튜플(y, x) 배열화
# y, x의 범위가 1 ~ N-1인 이유는 가장자리가 시작점인 경우 꽃을 피울 수 없기 떄문에 배제한 것

COORDS = [(y, x) for y in range(1, N - 1) for x in range(1, N - 1)]
# [
#   [1, 1],
#   [1, 2],
#   [1, 3],
#   ...
#   [5, 5]
# ]

# 좌표 3개를 조합으로 고름 [ [1, 1], [3, 5], [4, 2] ] 등
for coords in combinations(COORDS, 3):
    # 좌표 3개가 서로 닿지 않는 가능한 조합인지 확인.
    bfs(coords)

print(ANS)
