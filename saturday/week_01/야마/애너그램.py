import sys

read = lambda: sys.stdin.readline().rstrip()

T = int(read())#갯수입력받기

for _ in range(T):
    A, B = map(str, read().split())#비교할글자 받기

    X = sorted(list(A))
    Y = sorted(list(B))#정렬

    if X == Y:
        print('{} & {} are anagrams.'.format(A, B))
    else:
        print('{} & {} are NOT anagrams.'.format(A, B))
