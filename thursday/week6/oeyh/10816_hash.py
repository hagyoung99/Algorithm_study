import sys

n = int(sys.stdin.readline())
card_arr = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
value_arr = list(map(int, sys.stdin.readline().split()))

hashmap = {}
result_arr = []

for card in card_arr:
    if card in hashmap:
        hashmap[card] += 1
    else:
        hashmap[card] = 1

for value in value_arr:
        if value in hashmap:
            result_arr.append(hashmap[value])
        else:
            result_arr.append('0')
result = ''.join(map(str, result_arr))

print(result)