import sys
input = sys.stdin.readline
n, m = map(int, input().split())
# 딕셔너리가 리스트보다 메모리는 크지만 속도는 훨씬 빠르다.
s = {input().rstrip() for _ in range(n)}
ans = 0
print(s)

for j in range(m):
    word = input().strip()
    if word in s:
        ans += 1
print(ans)