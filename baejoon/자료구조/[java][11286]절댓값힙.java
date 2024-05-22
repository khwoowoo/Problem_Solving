//다시 풀기
//한 번에 성공공
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Node{
        public int abs;
        public int origin;

        Node(int abs, int origin){
            this.abs = abs;
            this.origin = origin;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pr = new PriorityQueue<>((a, b) -> {
            if (a.abs == b.abs) return a.origin - b.origin;

            return a.abs - b.abs;
        });

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();

            if(x == 0){
                int temp = 0;
                if(pr.size() != 0) temp = pr.poll().origin;
                sb.append(temp).append('\n');
            } 
            else{
                pr.add(new Node(Math.abs(x), x));
            }
        }

        System.out.println(sb.toString());
        
    }
}

/*
이 문제를 우선 순위 큐를 사용하고 비교하는 함수를 따로 구현하는 되는 문제
출력은 한 번에 출력하는 StringBuilder 방식을 사용하는 게 좋을 듯?


*/




//비교하는 방법이 아래 주석과 같은 부분인데
//비효율적이라서 gpt가 고쳐줌...
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 비교 함수 수정: 절댓값이 같을 때는 원래의 수를 비교
        Comparator<SimpleEntry<Integer, Integer>> comparator = (a, b) -> {
            int absCompare = a.getKey().compareTo(b.getKey());
            if (absCompare == 0) return a.getValue().compareTo(b.getValue());
            else return absCompare;
        };

        PriorityQueue<SimpleEntry<Integer, Integer>> queue = new PriorityQueue<>(comparator);

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            // x가 0이 아닐 때는 (절댓값, 원래 값)을 큐에 추가
            if (x != 0) { queue.offer(new SimpleEntry<>(Math.abs(x), x));} 
            else {
                // x가 0일 때 큐가 비어있으면 0 출력, 그렇지 않으면 최소 절댓값을 가진 원소 출력 후 제거
                if (queue.isEmpty()) {System.out.println(0);} 
                else { System.out.println(queue.poll().getValue());}
            }
        }
    }
}

/*
시간 자바 기준 2초
기능
 - x를 입력하면 추가 (X != 0)
 - 0이면 절댓값이 가장 작은 거 출력
 - 비워있는 경우 0 출력

일단 우선순위 큐를 사용하면서
튜플사용해서 절댓값, 원본 이렇게하기
출력할 때는 일단 두 개 이상뽑고
같은 값이 아니면 다시 넣기

연간 개수 N 입력
우선순위 큐 선언
for N번 반복:
 - 입력
 - if x이면 넣기
 - else if 0인데 사이즈가 0이면 출력
 - else 0이면 빼기
     - 일단 한 뽑기
     - 리스트 선언
     - while 우선순위큐 사이즈가 되면 여러 개 뽑기 (처음에 뽑은 거랑 다르면 다시 넣고 종료)
     - if 리스트 사이즈가되면
         - 하나씩 비교해서 작은거 추출
*/
