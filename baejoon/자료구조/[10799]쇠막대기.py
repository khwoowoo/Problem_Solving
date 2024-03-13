A = input()
stack = []
result = 0
previous = ''

for i in A:
    if i == '(': stack.append('(')
    elif i == ')' and previous == '(': 
        stack.pop()
        result += len(stack)
    elif i == ')' and previous == ')': 
        stack.pop()
        result += 1
    
    previous = i
print(result)


# GPT한테 리팩토링해달라고 함
input_string = input()
stack = []
total_pieces = 0

for index, char in enumerate(input_string):
    if char == '(':
        stack.append(index)  # 인덱스 저장
    else:  # char == ')'
        start = stack.pop()  # 시작 인덱스
        # 레이저인 경우
        if index - start == 1:
            total_pieces += len(stack)
        else:  # 쇠막대기의 끝인 경우
            total_pieces += 1

print(total_pieces)
