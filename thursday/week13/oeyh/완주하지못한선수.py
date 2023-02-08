from collections import Counter

def solution(participant, completion):
    answer = []
    p_dict = Counter(participant)
    c_dict = Counter(completion)

    p_dict.subtract(c_dict)

    for p in set(participant):
        if p_dict[p] > 0:
            answer.append(p)

    return ''.join(answer)