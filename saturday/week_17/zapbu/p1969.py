import sys
N, M = map(int, input().split())

DNAS = [input() for _ in range(N)]

ANS = ''
CNT = 0

for i in range(M):
    mp = {}
    for dna in DNAS:
        c = dna[i]
        if mp.get(c) == None:
            mp[c] = 0
        mp[c] += 1

    c, cnt = sorted(mp.items(), key=lambda v: (-v[1], v[0]))[0]
    ANS += c
    CNT += N - cnt

print(ANS)
print(CNT)
