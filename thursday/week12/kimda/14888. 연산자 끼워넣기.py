import sys
input = sys.stdin.readline

n = int(input())
num_lst = list(map(int, input().split()))
op_lst = list(map(int, input().split()))
max_ = -1e9
min_ = 1e9

ans = num_lst[0]
def dfs(index):
    global ans
    global max_, min_
    if index == n:
        if ans > max_:
            max_ = ans
        if ans < min_:
            min_ = ans
        return

    for i in range(4):
        tmp = ans
        if op_lst[i] > 0:
            if i == 0:
                ans += num_lst[index]
            elif i == 1:
                ans -= num_lst[index]
            elif i == 2:
                ans *= num_lst[index]
            else:
                if ans >= 0:
                    ans //= num_lst[index]
                else:
                    ans = (-ans // num_lst[index]) * -1
            op_lst[i] -= 1
            dfs(index + 1)
            ans = tmp
            op_lst[i] += 1

dfs(1)
print(max_)
print(min_)
