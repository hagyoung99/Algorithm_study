def solution(phone_book):
    numbers = dict()

    for number in phone_book:
        for i in range(len(number)):
            numbers[number[:i]] = 1

    for p in phone_book:
        if p in numbers:
            return False
    return True
