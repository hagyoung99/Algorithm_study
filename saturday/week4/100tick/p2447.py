N = int(input())

# ==============================
# 1. '*'로 이루어진 N x N 배열로 초기화
# 별을 먼저 그린 후에 공백을 삽입할 것
BOARD = [["*"]*(N+1) for _ in range(N+1)]
# 직관적인 이해를 위해 1행 1열은 만들기만 하고 버린다.

# 3x3 2차원 배열의 경우 index 0~2이지만
# 1행 1열을 버리면 1~3으로 사용 가능
# 나중에 출력 시 1행 1열을 순회에서 배제하면 됨


def insert_space(y_start, x_start, length):
    # 가로/세로 길이의 3분의 1
    third = length//3

   # 1. 모든 칸을 '*'로 미리 채운 상태
   # 중간을 ' ' 공백으로 비워줌
   #
   # [CASE 1]
   # 3x3인 경우, 열 (1,[2],3), 행 (1,[2],3) 중에서
   # 중간 값인 (2, 2)만 버려줌
   # ***    ***
   # *** -> * *
   # ***    ***
   #
   # [CASE 2]
   # 9x9인 경우,
   # 시작 인덱스 1+ 길이의 3분의 1 = [4] ~ 시작 인덱스 1+ 길이의 3분의 1 x 2 = [7]
   # 즉 행, 열이 [4~6]인 경우(slice이므로 7은 포함x) 공백 삽입
   # 1,2,3 = 별, 4,5,6 = 공백, 7,8,9 = 별이 됨
   # *********    *********
   # *********    *********
   # *********    *********
   # *********    ***   ***
   # ********* -> ***   ***
   # *********    ***   ***
   # *********    *********
   # *********    *********
   # *********    *********
   # 4행 4열, 4행 5열, 4행 6열
   # 5행 4열, 5행 5열, 5행 6열
   # 6행 4열, 6행 5열, 6행 6열
   # 만 공백 처리가 된 것
   #
   # 이 2중 for문이 1+3분의1~3분의1x2까지 ' '공백을 채우는 부분 (9x9인 경우 4,5,6)
    for y in range(y_start+third, y_start + third*2):
        for x in range(x_start+third, x_start + third*2):
            BOARD[y][x] = ' '

    # 재귀 종료 조건
    # 3x3이 최소 크기이므로 더 이상 재귀를 호출할 필요 없으므로 종료
    # 만약 이 조건을 삽입하지 않으면 아래에서 index out of bound 오류 발생
    if length == 3:
        return

    # 사각형을 9조각으로 쪼갬
    # 9x9=81, 3x3=9
    # 3배수로 커지는데, 그 때마다 넓이가 딱 9배
    # 그래서 9x9를 쪼개는 과정을 나열하면
    #     123   456   789
    #  1 [***] [***] [***]
    #  2 [***] [***] [***]
    #  3 [***] [***] [***]
    #
    #  4 [***] [   ] [***]
    #  5 [***] [   ] [***]
    #  6 [***] [   ] [***]
    #
    #  7 [***] [***] [***]
    #  8 [***] [***] [***]
    #  9 [***] [***] [***]
    #
    # 9x9 크기의 사각형의 경우,
    # 1~10(9회) 순회하는데, 한 번에 3분의 1인 3씩 증가시킴
    # f(1, 1, 3)
    # f(1, 4, 3)
    # f(1, 7, 3)
    # f(4, 1, 3)
    # f(4, 4, 3) -> 공백이므로 실행 안 됨, 근데 실행 해도 어차피 공백에 공백을 채워도 공백이니 통과 됨
    # f(4, 7, 3)
    # f(7, 1, 3)
    # f(7, 4, 3)
    # f(7, 7, 3)
    # []
    for y in range(y_start, y_start+length, third):
        for x in range(x_start, x_start+length, third):
            if BOARD[y][x] != ' ':
                insert_space(y, x, third)


insert_space(1, 1, N)

for y in range(1, N+1):
    for x in range(1, N+1):
        print(BOARD[y][x], end='')
    print()
