S = int(input())

CNT = 0
n = 1

while S > -1:
    S -= n
    n += 1
    CNT += 1

print(CNT-1)
