from collections import deque
n = int(input())
card = deque()
for i in range(1, n + 1):
    card.append(i)

while len(card) >= 1:
    if len(card) == 1:
        print(*card)
        break
    card.popleft()
    card.append(card.popleft())