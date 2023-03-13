import sys
input = sys.stdin.readline

N = int(input())

A, B, C, D = [], [], [], []

# 4중 for문으로 구할 경우
# 시간 복잡도 - N^4


for _ in range(N):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB = {}
CD = {}
# (A, B) 순서쌍의 합을 AB dict에 저장
for a in A:
    for b in B:
        n = a+b
        if not AB.get(a+b):
            AB[a+b] = 1
        else:
            AB[a+b] += 1
        # if n not in AB:
            # AB[n] = 0
        # AB[n] += 1

ANS = 0
# (C, D) 순서쌍의 합을 더해서 AB에 역수가 있는지 확인
#
for c in C:
    for d in D:
        ab = -(c+d)
        if ab in AB:
            ANS += AB[ab]
        # for ab, ab_cnt in AB.items():
        #     print('========')
        #     print(ab, ab_cnt, CD.get(-ab))
        #     print('========')
        #     cd_cnt = CD.get(-ab)
        #     if cd_cnt is not None:
        #         ANS += ab_cnt * cd_cnt

print(ANS)
