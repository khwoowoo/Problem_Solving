times = int(input())

def VPS(data):
  count = 0

  for i in data:
    if i == '(': count += 1
    else : count -= 1

    if count < 0 : return 'NO'
  
  return 'YES' if count == 0 else 'NO'

for data in range(times):
  print(VPS(input()))
