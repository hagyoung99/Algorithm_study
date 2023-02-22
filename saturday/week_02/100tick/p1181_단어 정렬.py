##########################################
#
# p1181 [단어 정렬]
#
# [문제]
# 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라
# 정렬하는 프로그램을 작성하시오.
# 길이가 짧은 것부터, 길이가 같으면 사전 순으로
#
# [입력]
# 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
# 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
# 주어지는 문자열의 길이는 50을 넘지 않는다.
#
# [출력]
# 조건에 따라 정렬하여 단어들을 출력한다.
# 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
#
# [https://www.acmicpc.net/problem/1181]
#
##########################################
# IMPORT
##########################################
import sys
from typing import List, Set, Dict, Tuple
from functools import cmp_to_key
#
#
#
# C++ 대비 약 메모리 6배, 시간 9배 소요
#
# Python에서는 기본적으로 input()으로 입력이 가능함
#
# C++:
# int n;
# cin >> n;
#
# Python:
# n = input()
#
# 하지만 기본적으로 속도가 느리기 때문에
# 빠른 입력을 위해서 sys.stdin.readline을
# input으로 사용하도록 overwrite 했음
#
#
input = sys.stdin.readline

##########################################
# 비교 함수(미사용)
##########################################
#
#
# 정렬을 위해 비교 위한 함수를 만들었으나
# Python에서는 웬만한 정렬은 따로 비교 함수가 필요 없었음
#
#


def cmp(a: Tuple[str, int], b: Tuple[str, int]) -> bool:
    len_a = a[1]
    len_b = b[1]
    word_a = a[0]
    word_b = b[0]

    if (len_a == len_b):
        return word_a < word_b
    return len_a < len_b


##########################################
# INPUT
##########################################
#
# 1. 입력 받을 단어의 갯수 INPUT
#
N: int = int(input())
#
# <입력 받을 단어(KEY) : 단어의 길이(VALUE)> 형태로 저장할 DICTIONARY
# DICTIONARY = KEY-VALUE 자료구조
# 다른 언어에서는 MAP, HASH MAP 등으로 불림
word_dt: Dict[str, int] = {}
#
# 2. N개의 단어 INPUT, word_dt에 저장
#
for _ in range(N):
    #
    # N개의 word INPUT
    #
    word = input().strip()
    #
    # word dt에 <word: length> 형태로 저장
    #
    if word not in word_dt:
        word_dt[word] = len(word)

##########################################
# SORT
##########################################
#
#
# Dict를 (str, int) 형태의 Tuple로 변환
# Dict는 KEY, VALUE라는 2가지 값을 갖기 때문에
# list로 변환 시, 각 요소가 (KEY, VALUE) 형태의 Tuple이 되는 것
#
#
word_list: List[Tuple[str, int]] = list(word_dt.items())
#
# Python에서의 Sort는 lambda를 통해 매우 간단하게 구현 가능
# tp는 위에서 변환한 (KEY, VALUE) 형태의 튜플을 의미
# tp[0]은 단어를, tp[1]은 해당 단어의 길이를 저장
# 만약 길이에 대한 오름차순으로 저장하고 싶은 경우
#
# word_list.sort(key=lambda tp: tp[1])
# 위 로직으로 정렬 가능
# lambda tp: (tp[1], tp[0])은
# tp[1], 길이에 대한 오름차순으로 정렬하고
# 길이가 같을 경우 tp[0], 문자의 유니코드에 따라 오름차순 정렬 하라는 것
#
# word_list.sort(key=lambda tp: -tp[1])
# 내림차순으로 정렬하고 싶은 경우, 정렬하고 싶은 값에 -만 붙여주면 됨
#
#
word_list.sort(key=lambda tp: (tp[1], tp[0]))
#
#
##########################################
# OUTPUT
##########################################
for s in word_list:
    print(s[0])
