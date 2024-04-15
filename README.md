## 코딩테스트 연습 🔥

### 공부 방법 🔥
 - 다양한 종류의 문제 어느 정도 풀면
 - 알고리즘 종류대로 50 문제씩 풀기
 - 이전에 틀린 문제들 다시 풀기

### 문제 고민 시간 🔥
 - 골드2까지 1~2 시간 고민하고 답안 보기
 - 골드 2 ~ 플레까지는 4시간 고민하고 답압보기

### 코테 문제 🔥
 - 백준 강의에서 제공하는 문제 풀기 (강의 영상 x)
   - 알고리즘 기초 1/2
   - 알고리즘 중급 1
   - https://code.plus/bundles/1
 - 프로그래머스 고득점 KIT
 - 유튜브, 인프런 무료 강의에서 나오는 문제 먼저 풀고 해설 보기 (영상에서는 나오는 문제는 공부하기 좋은 문제이고 해설까지 볼 수 있는)


### 문제 푸는 방법 🔥
 - 시간을 보고 알고리즘 최대 시간 복잡도 측정하기
 - 최대 시간 복잡도 안에 할 수 있는 방법 여러 가지 생각하기
 - 자료구조 사용한다면 어떤 자료구조가 효율적으로 해결할 수 있는지 고민하기
 - 수도 코드 먼저 작성하고 검증하기 (실제 코테볼 때 종이 개수가 제한적일 수 있으니, 까다로운 문제 아니면 주석에 작성하기. 그리고 살짝 번거로움 ㅎ)
 - 그 다음 구현으로 넘어가기

### 슈도코드 작성 예시 🔥
 - 제일 좋은 방법은 본인이 익숙하고 편한걸로 작성하는 것이 중요!
 - 아래는 DFS 수도코드 예시
```
n(노드 개수) m(에지 개수)
A(그래프 데이터 저장 인접 리스트)
visited(방문기록 저장 배열)

for(n의 개수만큼 반복하기){
  A 인접 리스트의 각 ArrayList 초기화하기
}

for(n의 개수만큼 반복하기){
  if (방문하지 않은 노드가 있으면)
    연결 요소 개수 ++
    DFS 실행하기
}

//DFS 구현하기
function DFS{
  if (현재 노드 == 방문 노드) return;

  visited 배열에 현재 노트 방문 기록하기
  현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 이용)
}

```
### 온라인 개발 환경 🔥
[클릭!](https://www.mycompiler.io/ko/new/java)
