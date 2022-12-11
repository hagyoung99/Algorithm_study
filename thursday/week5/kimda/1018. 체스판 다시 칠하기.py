n, m = map(int, input().split())
boards = [input() for _ in range(n)]
result = 64

for start_i in range(n - 7):
    for start_j in range(m - 7):
        count_b = 0
        count_w = 0
        for i in range(start_i, start_i + 8):
            for j in range(start_j, start_j + 8):
                if (i + j) % 2 == 0:
                    if boards[i][j] != 'B':
                        count_b += 1
                    if boards[i][j] != 'W':
                        count_w += 1
                else:
                    if boards[i][j] != 'W':
                        count_b += 1
                    if boards[i][j] != 'B':
                        count_w += 1
        result = min(result, count_b, count_w)

print(result)