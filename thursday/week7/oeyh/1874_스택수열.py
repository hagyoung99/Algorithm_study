import sys

n = int(sys.stdin.readline())

stack = []
result = []
flag = True
c = 1

for _ in range(n):
    num = int(sys.stdin.readline())

    while c <= num:
        stack.append(c)
        result.append("+")
        c += 1
    else:
        if stack[-1] == num:
            stack.pop()
            result.append("-")
        else:
            flag = False
if flag:
    for i in result:
        print(i)
else:
    print("NO")


