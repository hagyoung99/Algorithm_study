n = int(input())
for i in range(n):
    data = list(input())
    sum_ = 0
    for j in data:
        if j == '(':
            sum_ += 1
        elif j == ')':
            sum_ -= 1
        if sum_ < 0:
            print('NO')
            break
    if sum_ > 0:
        print('NO')
    elif sum_ == 0:
        print('YES')