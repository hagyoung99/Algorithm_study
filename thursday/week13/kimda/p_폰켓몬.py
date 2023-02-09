def solution(nums):
    ans = []
    for num in nums:
        if num not in ans:
            ans.append(num)

    # 결과값은 (len(num) // 2)의 값을 넘지 않되, 중복되지 않은 숫자들의 갯수를 세어주면 된다.
    if len(ans) > len(nums) // 2:
        answer = len(nums) // 2
    else:
        answer = len(ans)
    return answer