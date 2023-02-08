def solution1(nums):
    result = []

    for n in set(nums):
        result.append(n)
        if len(result) == len(nums)/2:
            break

    return len(result)


def solution2(nums):
    return min(len(set(nums)), len(nums)//2)