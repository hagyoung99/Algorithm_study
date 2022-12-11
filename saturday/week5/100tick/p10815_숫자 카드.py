import sys
input = sys.stdin.readline

# my_cards
N = int(input())
my_cards = list(map(int, input().split()))

# cards
M = int(input())
cards = list(map(int, input().split()))

my_cards.sort()


# check if my_cards includes a given card
def has_card(card: int):
    global my_cards

    left = 0
    right = len(my_cards)-1
    pivot = (left + right) // 2
    
    while left <= right:
        if my_cards[pivot] == card:
            return 1
        # my_card at pivot less than card
        if my_cards[pivot] < card:
            left = pivot+1
        # my_card at pivot bigger than card
        else:
            right = pivot-1
        
        pivot = (left + right)//2
    
    return 0



for c in cards:
    print(has_card(c), end=' ')
