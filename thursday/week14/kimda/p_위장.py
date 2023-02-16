# 에제 1번
# 가능한 조합의 수 'headgear' 두 가지 중 하나만 입거나 둘 다 안입거나(3가지)
# 'eyewear' 입거나 안입거나(2가지)
# 총 경우의 수 3 * 2 => 문제에서 옷 하나는 무조건 입어야 된다고 했으니까 -1 답은 5

def solution(clothes):
    closet = {}
    answer = 1
    # 같은 종류의 옷끼리 묶어서 사전에 저장
    for cloth in clothes:
        if cloth[1] in closet.keys():
            closet[cloth[1]].append(cloth[0])
        else:
            closet[cloth[1]] = [cloth[0]]
    # closet : {'headgear': ['yellow_hat', 'green_turban'], 'eyewear': ['blue_sunglasses']}
    # 경우의 수 구하기
    for value in closet.values():
        # 1을 더해주는 이유는 종류마다 안 입는 경우도 넣어주기 위해서다
        answer *= len(value) + 1

    # 모든 종류의 옷을 입지 않은 경우 하나 제외
    return answer - 1