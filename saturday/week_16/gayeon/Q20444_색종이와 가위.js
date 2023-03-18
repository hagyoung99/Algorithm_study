/*
import sys

N, K = map(int, sys.stdin.readline().split())

def binarySearch(left, right): 
    while left <= right: 
        mid = (left + right) // 2 # mid는 가로로 자른 횟수
        value = (mid+1) * ((N-mid)+1) # value는 조각의 개수
        if value > K:
            right = mid - 1
        elif value < K:
            left = mid + 1
        else:
            print('YES')
            return
    print('NO')
    return

binarySearch(0, N//2)   // 몫 구하는 연산자래...몰랐다..
*/

// https://velog.io/@zigje9/%EB%B0%B1%EC%A4%80-20444-%EC%83%89%EC%A2%85%EC%9D%B4%EC%99%80-%EA%B0%80%EC%9C%84
// 나는 똥멍청이다..