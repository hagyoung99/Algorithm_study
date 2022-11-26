import sys
#string으로 입력받아 각각 문자를 for문으로 나눠 reverse를 true로 하여 역순 정렬
n = sys.stdin.readline()
li = []
for i in n:
    li.append(i)
li.sort(reverse=True)

print(''.join(li))