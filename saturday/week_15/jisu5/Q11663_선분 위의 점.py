pointCnt, lineCnt = map(int, input().split())
pointList = sorted(list(map(int, input().split())))

def find_point_min(lineStart):
    start = 0
    end = pointCnt - 1
    while start <= end:
        mid = (start + end) // 2
        if pointList[mid] < lineStart:
            start = mid + 1
        else:
            end = mid - 1
    return start

def find_point_max(lineEnd):
    start = 0
    end = pointCnt - 1
    while start <= end:
        mid = (start + end) // 2
        if pointList[mid] > lineEnd:
            end = mid - 1
        else:
            start = mid + 1
    return end + 1

for _ in range(lineCnt):
    start, end = map(int, input().split())
    a = find_point_min(start)
    b = find_point_max(end)
    print(b - a)
