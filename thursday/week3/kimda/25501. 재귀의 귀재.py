def recursion(s, l, r, a):
    if l >= r: return (1, a)
    elif s[l] != s[r]: return (0, a)
    else: return recursion(s, l+1, r-1, a+1)

def isPalindrome(s):
    return recursion(s, 0, len(s)-1, 1)

# print('ABBA:', isPalindrome('ABBA'))
# print('ABC:', isPalindrome('ABC'))
ans = 0
n = int(input())
for i in range(n):
    word = input()
    print(*isPalindrome(word))