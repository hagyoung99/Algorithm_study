n = int(input())

if n % 2 == 1:
    print('SK')
else:
    print('CY')

##### DP #####
lst = [-1] * 1001
lst[1] = 1
lst[2] = 0
lst[3] = 1

for i in range(4, n + 1):
    if lst[i-1] or lst[i-3]:
        lst[i] = 0
    else:
        lst[i] = 1

if lst[n] == 1:
    print('SK')
else:
    print('CY')