data = input()
isTag = False
isBlank = False
result = ''
word = ''

for i in data:
    if i == '<': isTag = True
    elif i == '>': isTag = False
    
    if isTag or i == '>' or i == ' ':
        if len(word) > 0 :
            for j in range(len(word)-1, -1, -1):
                result += word[j]
            word = ''
        result += i
    else:
        word += i
for j in range(len(word)-1, -1, -1):
    result += word[j]
print(result)


# GPT한테 리팩토링 물어봤는데 word[::-1]이거 알려줌
'''
`text[::-1]`는 파이썬에서 문자열이나 리스트와 같은 시퀀스를 뒤집는 간결한 방법입니다. 이 구문은 슬라이싱(slicing)이라는 파이썬의 기능을 사용하는데, 슬라이싱을 통해 시퀀스의 일부분을 추출하거나 전체 시퀀스를 특정 순서로 접근할 수 있습니다.

`text[::-1]`에서:

- 첫 번째 콜론(`:`) 앞의 빈칸은 슬라이싱의 시작점을 시퀀스의 처음으로 지정합니다.
- 두 번째 콜론(`:`) 뒤의 빈칸은 슬라이싱의 끝점을 시퀀스의 마지막으로 지정합니다.
- `-1`은 슬라이싱의 "step"을 지정하는데, 이는 시퀀스를 역순으로 한 단계씩 건너뛰며 접근하라는 의미입니다.

따라서 `text[::-1]`은 `text` 시퀀스의 모든 요소를 역순으로 뒤집어서 반환합니다. 예를 들어, 문자열 `'hello'`에 이 구문을 적용하면 `'olleh'`가 됩니다.
'''
