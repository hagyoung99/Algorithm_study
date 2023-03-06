n = int(input())

def recursion(n):
    if n == 1 or n == 2:
        return 1
    else:
        return (recursion(n - 1) + recursion(n - 2));
cnt = 0
def fibonacci(n):
    global cnt
    f_lst = [0] * (n + 1)
    f_lst[1] = 1
    f_lst[2] = 1
    for i in range(3, n):
        cnt += 1
        f_lst[i] = f_lst[i - 1] + f_lst[i - 2]
    return cnt + 1

print(recursion(n), fibonacci(n))
