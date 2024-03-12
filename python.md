# 파이썬

## 입력

- 한 줄에 여러 번 입력해야 하는 경우
- map과 split으로 간편하게 작성할 수 있다.

```python
a, b = map(int, input().split())
```

## 빠른 입출력 함수

- input 함수가 느리기 때문에, sys의 `sys.stdin.readline()` 를 사용.

```python
for i in range(100):
	n = int(input())
	print(n)

# 더 빠른 방법
import sys

for i in range(100):
	n = int(sys.stdin.readline().rstrip())
	print(n)

# 간편하게 사용법
import sys
input = sys.stdin.readline

for i in range(100):
	n = int(input())
	print(n)
```

## Overflow

- 자료형이 담을 수 있는 범위를 초과한 값을 넣을 때 발생하는 문제
- 파이썬은 고려하지 않아도 된다

## 2차원 리스트

- 리스트 컴프리헨션으로 2차원 리스트 초기화할 때 효과적으로 사용할 수 있다.

```python
arr = [[0] * m for _ in range(n)]
arr = [ i for i in range (10) if i % 2 == 0]
```

## Stack, Queue

- 파이썬에서는 스택를 제공하지 않는다. 따라서 Stack은 리스트로 사용한다
- Queue은 따로 제공은 하나, 멀티스레드 환경에도 안전하게 동작하도록 설계 되어서 속도가 느리다. 따라서, deque를 사용하는 것이 더 좋다.

```python
s = []
s.append(123)
s.append(456)
s.append(789)

print('size: ', len(s))

# -1을 사용하는 경우는 원래 다른 언어라면 오류가 나지만
# 파이썬에서 인덱스가 음수이면 반대로 동작하기 때문에
# 가장 상단에 있는 값을 가져
while len(s) > 0:
		print(s[-1])
		s.pop(-1) # s.pop() 생략도 가능

#==================================================================
from collections import deque

q = deque()
q.append(123)
q.append(456)
q.append(789)
print('size: ', len(q));
while len(q) > 0:
		print(q.popleft())

```

## Priority Queue(Heap)

- 파이썬에서 제공하는 힙은 min-heap이다.
- 물론, 파이썬에서 PriorityQueue 모듈을 제공하나 thraed-safe라서 느리다는 점이 있다.

```python
import heapq

pq = []
heapq.heappush(pq, 456)
heapq.heappush(pq, 123)
heapq.heappush(pq, 789)

print('size : ', len(pq))
while len(pq) > 0:
		print(heapq.heapqpop(pq))

```

## Set

- Set은 파이썬에서 제공한다

```python
s = set()
s.add(123)
s.add(546)
s.add(888)
s.add(1623)
s.add(77)
s.remove(123)

print('size : ', len(s))
for i in s:
		print(i)

a = set([1,2,3,4,5])
b = set([3,4,5,6,7])

#합집합
print(a | b)

#교집합
print(a & b)

#합집합
print(a - b)

```

## 람다 표현식

- 람다 표현식을 이용하면 함수를 간단하게 작성할 수 있다.

```python
def add(a, b):
	return a + b

# 일반적인 add() 메서드 사용
print(add(3, 7))

#람다 표현식으로 구현한 add() 메서드
print((lambda a, b: a + b)(3, 7))
```

- 내장 함수에사 자주 사용되는 람다 함수
    - 튜플 값 중 숫자로 정렬하고 싶을 때
    
    ```python
    arr = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]
    
    def my_key(x):
    	return x[1]
    
    print(sorted(array, key=my_key))
    print(sorted(array, key=lambda x: x[1]))
    ```
    
    - 여러 개 리스트에 적용
    
    ```python
    list1 = [1, 2, 3, 4, 5]
    list2 = [6, 7, 8, 9, 10]
    
    result = map(lambda a, b: a + b, list1, list2)
    
    print(list(result)) # [7, 9, 11, 13, 15]
    ```
    

## 실전에서 유용한 표준 라이브러리

- 내장함수: 기본 입출력 함수부터 정렬 함수까지 기본적인 함수들을 제공

```python
result = sum([1, ,2 , 3, 4, 5])
print(result)

min_result = min(7, 3, 5, 2)
max_result = max(7, 3, 5, 2)
print(min_result, max_result)

result = eval("(3+5)*7")
print(result)

result = sorted([9, 1, 8, 5, 4])
reverse_result = sorted([9, 1, 8, 5, 4], reverse = True)
print(result)
print(reverse_result)

array = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]
result = sorted(array, key=lambda x:x[1], reverse=True)
```

- itertools: 파이썬에서 반복되는 형태의 데이터를 처리하기 위한 유용한 기능들을 제공
    - 특히 순열과 조합 라이브러리는 코딩 테스트에서 자주 사용된다
    - 모든 경우의 수를 고려해야 할 때 어떤 라이브러리를 효과적으로 사용할 수 있을까?
    - 순열: 서로 다른 n개에서 서로 다른 r개를 선택하여 일렬로 나열하는 것

```python
from itertools import permutations

data = ['A', 'B', 'C']

result = list(permutations(data, 3))
print(result)
```

```python
from itertools import combinations

data = ['A', 'B', 'C']

result = list(combinations(data, 2))
print(result)
```

```python
from itertools import product

data = ['A', 'B', 'C']

#중복 순열
#2개를 뽑는 모든 순열 구하기 (중복 허용)
result = list(product(data, repear=2))
print(result)
```

```python
from itertools import combinations_with_replacement

data = ['A', 'B', 'C']

#중복 조합
#2개를 뽑는 모든 조합 구하기 (중복 허용)
result = list(combinations_with_replacement(data, repear=2))
print(result)
```

- heapq: 힙 자료구조를 제공한다
- bisect: 이진 탐색 기능을 제공
- collections: deque, Counter 등의 유용한 자료구조를 포함한다

```python
from collections import Counter

counter = Counter(['red', 'green', 'red', 'blue', 'red'])
print(counter['red'])
print(counter['green'])
print(dict(counter))
```

- math: 필수적인 수학적 기능을 제공
    - 팩토리얼, 제곱근, GCD, 삼각함수 관련 함수, pi 같은 상수

```python
import math

# 최소 공배수
def lcm(a, b)
	return a * b // math.gcd(a, b)

print(math.gcd(a, b))
print(lcm(21, 14))
```

## 재귀 함수 오류 해결

- 재귀함수가 너무 오바 되면 오류남
- 제한이 있어서

```python
import sys
sys.setrecursionlimit(10 ** 7)
```

## 온라인 개발 환경

- 리플릿
[Python Online Compiler & Interpreter](https://replit.com/languages/python3)
