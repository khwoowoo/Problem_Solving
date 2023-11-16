from collections import deque

cards = deque(range(1, int(input()) + 1))

if len(cards) == 1:
  print(cards.popleft())
else:
  while True:
    cards.popleft()
    
    if len(cards) == 1:
      print(cards.popleft())
      break
  
    cards.append(cards.popleft())
