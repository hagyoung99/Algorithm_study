S = input()

strs = set()

for i in range(len(S)):
    for j in range(len(S)+1):
        if i == j:
            continue
        strs.add(S[i:j])

strs.remove('')
print(len(strs))
