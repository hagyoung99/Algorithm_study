from collections import Counter
input()
A = list(map(int, input().split()))
B = list(map(int, input().split()))

CA = Counter(A)
CB = Counter(B)

print(len(list(filter(lambda n: n not in CB, A)) +
      list(filter(lambda n: n not in CA, B))))
