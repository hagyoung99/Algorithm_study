import sys


def isBalance(bw):
    stack = []

    for s in bw:
        if s == "(":
            stack.append(s)
        elif s == ")":
            if len(stack) == 0 or stack[-1] != "(":
                return "no"
            stack.pop()
        elif s == "[" :
            stack.append(s)
        elif s == "]":
            if len(stack) == 0 or stack[-1] != "[":
                return "no"
            stack.pop()
        else:
            #입력의 괄호 기준보다는 문자열이 많으므로 if 조건 검사 시 일반 문자열 처리를 먼저하는 것이 좋을 것 같음
            pass
    if len(stack) == 0 and len(stack) == 0:
        return "yes"
    else:
        return "no"


while True:
    balanced_world = sys.stdin.readline().rstrip()
    if balanced_world == ".":
        break

    print(isBalance(balanced_world))

