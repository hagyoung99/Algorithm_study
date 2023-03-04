org = int(input())
budgetList = list(map(int, input().split()))
target = int(input())

result = 0

def sum_budget(maxBudget):
    sum = 0
    for budget in budgetList:
        sum += budget if budget < maxBudget else maxBudget
        if sum > target:
            return False
    return True

if sum(budgetList) > target:
    maxBudget = max(budgetList)
    minBudget = 0
    while minBudget <= maxBudget:
        mid = (minBudget + maxBudget) // 2
        if sum_budget(mid):
            result = mid
            minBudget = mid + 1
        else:
            maxBudget = mid - 1
    print(result)
else:
    print(max(budgetList))