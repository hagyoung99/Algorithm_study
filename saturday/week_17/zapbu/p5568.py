from itertools import permutations
import sys
input = sys.stdin.readline

N = int(input())
K = int(input())

cards = [input().strip() for _ in range(N)]

MP = {}

for comb in permutations(cards, K):
    c = ''.join(comb)
    MP[c] = 1

print(len(MP))
