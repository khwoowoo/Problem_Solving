# 숫자를 이용한 방법
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

# 스택을 이용한 방법
N = int(input())
stack = []

for _ in range(N):
    paren = input()
    isFailed = False
    stack.clear()
    for item in paren:
        if item == '(': stack.append(item)
        else: 
            if len(stack) > 0: stack.pop()
            else: isFailed = True
    if isFailed == False and len(stack) == 0: print("YES")
    else: print("NO")
