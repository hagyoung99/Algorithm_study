H, W = map(int, input().split())

MAP = list(input() for _ in range(H))

ANS = 999999


def paint_num(y, x, pat):
    global ANS, MAP

    cnt = 0
    for i in range(8):
        for j in range(8):
            # [0] 1 0 1 0 1 0 1 - i+j가 짝수인 위치
           # <1> 0 1 0 1 0 1 0 - i+j가 홀수인 위치
            if (i+j) % 2:
                if MAP[y+i][x+j] != pat:
                    cnt += 1
            elif MAP[y+i][x+j] == pat:
                cnt += 1
    if cnt < ANS:
        ANS = cnt


for y in range(0, H-7):
    for x in range(0, W-7):
        paint_num(y, x, "B")
        paint_num(y, x, "W")

print(ANS)
