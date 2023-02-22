from collections import deque

N = int(input())

cards = deque()
for i in range(1, N+1):
    cards.appendleft(i)

while len(cards) > 1:
    cards.pop()
    cards.appendleft(cards.pop())

print(cards.pop())
