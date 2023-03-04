target = int(input())

sumN = 1
sum = 0
while sum < target:
  sum += sumN
  if sum == target:
    print(sumN)
    break;
  if sum > target:
    print(sumN-1)
    break;
  sumN += 1
