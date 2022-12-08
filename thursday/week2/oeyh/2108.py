import sys

n = int(sys.stdin.readline())
array = [int(sys.stdin.readline()) for i in range(n)]

#산술평군 - 소숫점 제거
mean = round(sum(array)/n)
#중앙값 - 입력값 크기에 맞춘 평균
median = sorted(array)[int((n-1)/2)]

mode_dic = {}
for i in range(n):
    if array[i] in mode_dic:
        mode_dic[array[i]] += 1
    else:
        mode_dic[array[i]] = 1

max_mode_dic = max(mode_dic.values())
mode_list = [k for k, v in mode_dic.items() if max_mode_dic == v]
#최빈값 - 입력 값을 딕셔너리로 빈도수 측정, value의 최댓값을 구한후 이에 해당하는 key list를 제작
mode = mode_list[0] if len(mode_list) == 1 else sorted(mode_list)[1]

print(mean)
print(median)
print(mode)
#범위
print(max(array)-min(array))
