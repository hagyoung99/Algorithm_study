cardCnt1 = int(input())
cards1 = list(map(int, input().split()))
cardCnt2 = int(input())
cards2 = list(map(int, input().split()))

cards1.sort()
result = ['0'] * cardCnt2

def find_card(card, target_cards, cards_length):
  left = 0
  right = cards_length - 1
  while left <= right:
    mid = (left + right) // 2
    if target_cards[mid] == card:
      return True
    elif target_cards[mid] < card:
      left = mid + 1
    else:
      right = mid - 1
  return False

for (idx, card) in enumerate(cards2):
  if findCard(card, cards1, cardCnt1):
    result[idx] = '1'

print(' '.join(result))