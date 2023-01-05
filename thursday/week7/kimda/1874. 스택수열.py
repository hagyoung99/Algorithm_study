n = int(input())
stack = []
sign = []
count = 1
temp = True
for i in range(n):
    num = int(input())
    while count <= num:
        stack.append(count)
        sign.append('+')
        count += 1
    if stack[-1] == num:
        stack.pop()
        sign.append('-')
    else:
        temp = False
if temp == False:
    print('NO')
else:
    for i in sign:
        print(i)