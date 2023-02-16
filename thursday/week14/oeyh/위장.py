def solution(clothes):
    dic = dict()
    cc = []
    selected = 1

    for cloth in clothes:
        if cloth[1] in dic:
            dic[cloth[1]].append(cloth[0])
        else:
            dic[cloth[1]] = [cloth[0]]

    for i in dic.values():
        cc.append(len(i) + 1)

    for i in cc:
        selected *= i

    return selected - 1