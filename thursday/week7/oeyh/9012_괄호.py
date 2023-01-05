import sys

def isVps(PS):
    stack = []
    for p in PS:
        if p == "(":
            stack.append(p)
        elif p == ")":
            if len(stack) == 0:
                return "NO"
            stack.pop()
    if len(stack) == 0:
        return "YES"
    else:
        return "NO"


T = int(sys.stdin.readline())

for _ in range(T):
    PS = sys.stdin.readline().rstrip()
    print(isVps(PS))
