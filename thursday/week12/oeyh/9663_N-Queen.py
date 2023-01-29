def queen(row):
    if row == N:
        global res
        res += 1
        return

    for i in range(N):
        if check[i]:
            continue

        board[row] = i
        possible = True
        for j in range(row):
            if board[row] == board[j] or (row - j == abs(board[row] - board[j])):
                possible = False
                break

        if possible:
            check[i] = True
            queen(row + 1)
            check[i] = False


if __name__ == '__main__':
    N = int(input())
    check = [False for _ in range(N)]
    board = [0 for _ in range(N)]
    res = 0

    queen(0)

    print(res)