s = input()
ans = set()

for i in range(len(s)):
    for j in range(i, len(s)):
        temp = s[i:j + 1]
        ans.add(temp)

print(len(ans))