T = int(input())
for tc in range(T):
    n, location = map(int, input().split())
    arr = list(map(int, input().split()))
    answer = 0
    while sum(arr) > 0:
        max_num = max(arr)
        for i in range(n):
            if max_num == arr[i]:
                answer += 1
                arr[i] = 0
                max_num = max(arr)
                if i == location and answer <= len(arr):
                    print(answer)