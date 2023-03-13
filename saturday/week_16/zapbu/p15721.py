import sys

PEOPLE = int(input())
T = int(input())
target = int(input())  # 0: 뻔, 1: 데기

# 0-1-0-1-0-0-1-1
#

round = 1
cnt = 0
ANS = 0

while 1:
    arr = [0, 1, 0, 1]
    for _ in range(round+1):
        arr.append(0)
    for _ in range(round+1):
        arr.append(1)

    for v in arr:
        if v == target:
            cnt += 1
        if cnt == T:
            print(ANS % PEOPLE)
            sys.exit()
        ANS += 1

    round += 1
