# 자바

## 라이브라리

```java
import java.util.*;
import java.lang.*;
import java.io.*;
```

## 입력

```java
//일반 입력
Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
int M = sc.nextInt();
sc.nextLine();

//빠른 입력
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
N = Integer.parseInt(br.readLine().trim());
M = Integer.parseInt(br.readLine().trim());

//한 줄에 여러 개 입력받을 때
StringTokenizer st = new StringTokenizer(br.readLine());
for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

```

## 출력

```java
//만약 알고리즘은 완벽한데 시간초과나면 System.out.println 사용하지 말고
//StringBuilder나 ‎BufferedWriter 사용해보삼
// 백준 11003번 출력 바꿔서 하니깐 해결 함 ㅜ

System.out.println(String.format("%d %d %d", A[i], target, Arrays.binarySearch(A, target)));
System.out.println(Arrays.toString(A));
System.out.println((int)(count / 2));

// StringBuilder 사용한 출력
// 출력을 그때 그때 하는 것보다 한번에 출력하기 위해 StringBuilder를 사용
StringBuilder sb = new StringBuilder(); 
for (int i = 0; i < M; i++) {
    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    
    sb.append(S[y] - S[x - 1]).append('\n'); 
}

System.out.println(sb.toString());

// BufferedWriter 사용한 출력
// 출력을 그때 그때 하는 것보다 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter를 사용
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
for (int i = 0; i < N; i++) {
  bw.write(mydeque.getFirst().value + " ");
}
bw.flush();
bw.close();

```

## 변수 선언

```java
String[] A = new String[5];
int[] B = {1, 2, 3};
int C = 2;
int D = new int[D];
```

## Arrays

```java
Integer A[] = {1, 2, 3, 4, 5};

// 정렬
Arrays.sort(A); // 오름차순
Arrays.sort(A, Collections.reverseOrder());  //내림차순
Arrays.sort(A, 2, 4);  // 일부만 정렬 (2~4만 정렬)

//오름차순 정렬된 상태인 경우 이진탐색 가능
Arrays.binarySearch(A, 2);

//리스트로 변경 배열 -> 배열 리스트
List<Integer> list  = Arrays.asList(A);

//범위 자르기
int B[] = Arrays.copyOfRange(A, 0, 1);

//배열의 길이
int[] C = new C[3];
System.out.println(C.length);

//문자열 길이
String D = "Coding Test";
System.out.println(D.length());

ArrayList<Integer> list = new ArrayList<>();
System.out.println(list.size());
```

## ArrayList

```java
ArrayList<String> list = new ArrayList<>();
list.add("ava");
list.add(0, "c++");
list.set(1, "java");
list.remove(1); // 이 시점에서 리스트는 ["c++"]입니다.

// 값 존재 유무 확인
boolean containsJava = list.contains("java");  // false
int indexOfCpp = list.indexOf("c++");   // 0, 존재하므로 0 인덱스 리턴

// 순회
Iterator<String> it = list.iterator();
while(it.hasNext()) {
    // 오름차순 순회
    String element = it.next();
}


// 중복 없이 삽입
String value = "some value";
if(list.indexOf(value) < 0) list.add(value);

// 리스트 값 하나씩 가져올 때
for(int i = 0; i < list.size(); i++) {
    String element = list.get(i);
}


//정렬
//1. Collections.sort()
Collections.sort(numbers); // 오름차순 정렬
Collections.sort(numbers, Collections.reverseOrder()); // 커스텀 정렬 (예: 내림차순)

//2. List.sort()
numbers.sort(null); // 오름차순 정렬
numbers.sort(Collections.reverseOrder()); // 커스텀 정렬 (예: 내림차순)

//3. 스트림 API 사용 
List<Integer> sortedNumbers = numbers.stream() // 오름차순 정렬
    .sorted()
    .collect(Collectors.toList());
List<Integer> sortedNumbersDesc = numbers.stream() // 커스텀 정렬 (예: 내림차순)
    .sorted(Collections.reverseOrder())
    .collect(Collectors.toList());



//binarySearch 이진 탐색 수행
int index = Collections.binarySearch(list, 5);

if (index >= 0) {
    System.out.println("Element found at index: " + index);
} else {
    System.out.println("Element not found. Insertion point: " + (-index - 1));
}



// 배열로 변환
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");

// 타입이 명확한 배열로 변환
String[] array = list.toArray(new String[0]); // 크기가 0인 배열을 넘겨도 됩니다.


```

## String

```java
// 문자열 슬라이싱 (부분 문자열 추출)
String str = "Hello, World!";
String sliced = str.substring(7, 12); // "World"

// 문자 접근
char ch = str.charAt(1); // 'e'

// 문자열을 배열로 변경
String str2 = "12345";
String[] A = str2.split("");
char[] charArray = str2.toCharArray(); // 문자열을 char 배열로 변환

// 문자열 변형
String lower = str.toLowerCase(); // "hello, world!"
String upper = str.toUpperCase(); // "HELLO, WORLD!"
String noSpaces = "  Hello, World!  ".trim(); // "Hello, World!"

// 문자열 변경
String name = "starfcks";
String newName = name.substring(0, 4) + "b" + name.substring(5);

// 문자열 비교
boolean result = "Hello".equals("hello"); // false
boolean resultIgnoreCase = "Hello".equalsIgnoreCase("hello"); // true

// 문자열 검색
boolean contains = str.contains("World"); // true
boolean starts = str.startsWith("Hello"); // true
boolean ends = str.endsWith("!"); // true

```

## HashMap

```java
// 선언
HashMap<String, Integer> map = new HashMap<>();

// key-value 넣기
map.put("java", 0);

// 값 가져오기
map.get("java");

// 키 존재 확인
if (!map.containsKey("java")) {
    map.put("java", 1);
}

// 특정 키가 없으면 값 설정, 있으면 기존 값 가져오는 함수
map.getOrDefault("java", 3);

// key 순회
for (String key : map.keySet()) {
    map.get(key);
}
```

## Stack

```java
// 스택 생성
Stack<Integer> stack = new Stack<>();

// 스택에 데이터 추가
stack.push(1);
stack.push(2);
stack.push(3);

// 스택의 가장 위에 있는 데이터 확인
System.out.println("Stack top: " + stack.peek()); // 출력: 3

// 스택에서 데이터 제거하면서 반환 받기
while (!stack.isEmpty()) {
    System.out.println(stack.pop());
}

// 이 시점에서 스택은 비어 있음
```
## Queue

```java
// Queue 선언
Queue<Integer> queue = new LinkedList<>();

// 요소 추가
queue.offer(1); // queue에 1 추가
queue.add(2);   // queue에 2 추가, offer와 비슷하지만 실패 시 예외 발생

// 요소 확인 (제거하지 않음)
System.out.println(queue.peek()); // 큐의 맨 앞 요소 확인, 비어있으면 null 반환
System.out.println(queue.element()); // 큐의 맨 앞 요소 확인, 비어있으면 NoSuchElementException 발생

// 요소 제거
System.out.println(queue.poll()); // 큐의 맨 앞 요소 제거 및 반환, 비어있으면 null 반환
System.out.println(queue.remove()); // 큐의 맨 앞 요소 제거 및 반환, 비어있으면 NoSuchElementException 발생

// 큐의 크기 확인
System.out.println(queue.size());

// 큐가 비어있는지 확인
System.out.println(queue.isEmpty());

// 큐 순회
for(Integer num : queue) {
    System.out.println(num);
}

// 큐 초기화
queue.clear();
```

## Deque

```java
// Deque 선언
Deque<Integer> deque = new ArrayDeque<>();

// 요소 추가
deque.addFirst(1); // 덱의 앞쪽에 1 추가
deque.offerFirst(2); // 덱의 앞쪽에 2 추가, addFirst와 유사하지만 실패 시 false 반환

deque.addLast(3); // 덱의 뒤쪽에 3 추가
deque.offerLast(4); // 덱의 뒤쪽에 4 추가, addLast와 유사하지만 실패 시 false 반환

// 요소 확인 (제거하지 않음)
System.out.println(deque.peekFirst()); // 덱의 맨 앞 요소 확인, 비어있으면 null 반환
System.out.println(deque.peekLast()); // 덱의 맨 뒤 요소 확인, 비어있으면 null 반환

// 요소 제거
System.out.println(deque.pollFirst()); // 덱의 맨 앞 요소 제거 및 반환, 비어있으면 null 반환
System.out.println(deque.pollLast()); // 덱의 맨 뒤 요소 제거 및 반환, 비어있으면 null 반환

// 덱의 크기 확인
System.out.println(deque.size());

// 덱이 비어있는지 확인
System.out.println(deque.isEmpty());

// 덱 순회
for(Integer num : deque) {
    System.out.println(num);
}

// 덱 초기화
deque.clear();
```

## Priority Queue

```java
// PriorityQueue 선언, Integer는 자연스러운 순서(오름차순)을 가짐
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

// 요소 추가
priorityQueue.offer(5);
priorityQueue.add(1);   // add와 offer는 유사하지만, 용량 제한으로 추가할 수 없을 때 add는 예외를 발생시킵니다.
priorityQueue.offer(3);

// 요소 확인 및 제거
System.out.println(priorityQueue.peek());   // 가장 우선순위가 높은 요소 확인, 여기서는 최솟값 1
System.out.println(priorityQueue.poll());   // 가장 우선순위가 높은 요소 제거 및 반환, 여기서는 1

// 남은 요소 확인
System.out.println(priorityQueue.peek());   // 이제 최솟값은 3

// 큐의 크기 확인
System.out.println(priorityQueue.size());

// 큐가 비어있는지 확인
System.out.println(priorityQueue.isEmpty());

// 우선순위 큐 순회
while (!priorityQueue.isEmpty()) {
    System.out.println(priorityQueue.poll());
}

// 우선순위 변경을 위한 Comparator 사용
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
maxHeap.offer(5);
maxHeap.offer(1);
maxHeap.offer(3);

// 가장 우선순위가 높은 요소 확인, 여기서는 최댓값 5
System.out.println(maxHeap.peek());
```

## Math

```java
int absInt = Math.abs(-10); // 10
double absDouble = Math.abs(-5.5); // 5.5

double ceilValue = Math.ceil(2.3); // 3.0
double floorValue = Math.floor(2.9); // 2.0
long roundValue = Math.round(2.5); // 3

int maxValue = Math.max(10, 20); // 20
int minValue = Math.min(10, 20); // 10

double powerValue = Math.pow(2, 3); // 8.0 (2의 3승)
double sqrtValue = Math.sqrt(9); // 3.0

double sinValue = Math.sin(Math.PI / 2); // 1.0
double cosValue = Math.cos(Math.PI); // -1.0
double tanValue = Math.tan(0); // 0.0

double asinValue = Math.asin(1.0); // PI/2

double logValue = Math.log(Math.E); // 1.0 (자연 로그)
double log10Value = Math.log10(100); // 2.0 (밑이 10인 로그)
```

## 순열, 조합, 중복 순열, 중복 조합

### **순열 (Permutation)**

- **정의**: 서로 다른 n개에서 r개를 선택하여 일렬로 나열하는 것.
- **수학적 표현**: *P*(*n*,*r*)=*n*!/(*n*−*r*)!
- **자바 구현 예시**: 재귀를 이용한 방법

```java
import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void permute(int[] arr, int depth, int n, int r, List<List<Integer>> result) {
        if (depth == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                temp.add(arr[i]);
            }
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1, n, r, result);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

```

### **2. 조합 (Combination)**

- **정의**: 서로 다른 n개에서 순서에 상관없이 r개를 선택하는 것.
- **수학적 표현**: *C*(*n*,*r*)=*n*!/[*r*!∗(*n*−*r*)!]
- **자바 구현 예시**: 재귀를 이용한 방법

```java
import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void combine(int[] arr, int depth, int n, int r, int index, List<Integer> current, List<List<Integer>> result) {
        if (r == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < n; i++) {
            current.add(arr[i]);
            combine(arr, depth + 1, n, r - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

```

### **3. 중복 순열 (Permutation with Repetition)**

- **정의**: 서로 다른 n개에서 중복을 허용하여 r개를 선택하여 일렬로 나열하는 것.
- **수학적 표현**: *nr*
- **자바 구현 예시**: 재귀를 이용한 방법

```java
import java.util.ArrayList;
import java.util.List;

public class PermutationWithRepetition {
    public static void permuteWithRepetition(int[] arr, int depth, int n, int r, List<Integer> current, List<List<Integer>> result) {
        if (depth == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < n; i++) {
            current.add(arr[i]);
            permuteWithRepetition(arr, depth + 1, n, r, current, result);
            current.remove(current.size() - 1);
        }
    }
}

```

### **4. 중복 조합 (Combination with Repetition)**

- **정의**: 서로 다른 n개에서 중복을 허용하여 r개를 선택하는 것.
- **수학적 표현**: *C*(*n*+*r*−1,*r*)=(*n*+*r*−1)!/[*r*!∗(*n*−1)!]
- **자바 구현 예시**: 재귀를 이용한 방법

```java
import java.util.ArrayList;
import java.util.List;

public class CombinationWithRepetition {
    public static void combineWithRepetition(int[] arr, int depth, int n, int r, int index, List<Integer> current, List<List<Integer>> result) {
        if (depth == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i =

```

## Steam, forEach

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squaredNumbers = numbers.stream()
                                      .map(n -> n * n)
                                      .collect(Collectors.toList());
```

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// forEach를 사용하여 리스트의 각 요소 출력
names.forEach(name -> System.out.println(name));

// 메서드 참조를 사용한 forEach
names.forEach(System.out::println);
```

## 온라인 개발 환경
[클릭!](https://www.mycompiler.io/ko/new/java)
