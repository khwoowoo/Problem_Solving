import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> A[] = new PriorityQueue[7];
        int result = 0;

        for (int i = 1; i <= 6; i++) {
            A[i] = new PriorityQueue<>((a, b) -> b - a); // 내림차순 우선순위 큐
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int plet = Integer.parseInt(st.nextToken());

            if (A[line].isEmpty()) {
                A[line].offer(plet);
                result++;
            } else {
                if (plet == A[line].peek()) {
                    continue;
                } else if (plet > A[line].peek()) {
                    result++;
                    A[line].offer(plet);
                } else {
                    while (!A[line].isEmpty() && plet < A[line].peek()) {
                        A[line].poll();
                        result++;
                    }
                    if (A[line].isEmpty() || plet != A[line].peek()) {
                        A[line].offer(plet);
                        result++;
                    }
                }
            }
        }
        System.out.print(result);
    }
}
/*
외계인 친구의 손이 수십억개
기타를 치고 싶음

기타는 1~6번줄까지 있음.
각 줄은 1~p개의 프렛으로 나누어져있음.

멜로디는 음의 연속이고, 각음은 줄에서 해당하는 프렛을 누르고 줄을 튕기면 연주할 수 있음
예를 들어, 4번 줄의 8번 프렛을 누르고 팅길 수 있음

근데 만약에 줄의 프렛을 여러 개 누르고 있다면 가장 높은 프렛의 음이 발생
예를 들어, 3번 줄의 5번 프렛을 이미 누르고 있다.
이때 7번 프렛을 누른 음을 연주하려면 5번 프렛을 누르는 손을 떼지 않고
다른 손가락으로 7번 프렛을 누르고 줄을 튕기면 된다.

여기서 2번 프렛의 음을 연구하려고 한다면, 5번과 7번 누르던 손가락을 뗀 다음 2번 프렛을 누르고
연주해야 한다.

이렇게 손가락을 프렛을 한 번 누르거나 떼는 것을 한 번 움직였다고 한다.
어떤 멜로디가 주어졌을 땨, 손가락의 가장 적게 움직는 회수를 구하는 프로그램을 작성

1초

2 8 -> 1
2 10 -> 1
2 12 -> 1
2 10 -> 1
2 5 -> 3
총 7

1 5 -> 1
2 3 -> 1
2 5 -> 1
2 7 -> 1
2 4 -> 3
1 5 -> 0
1 3 -> 2
총 9

여기서 알 수 있는 것은 다른 줄이면 프렛 상관없음

그러면 총 6개의 리스트/배열/맵에서 오름차순으로 상태를 관리하면 될 것 같음
우선순위 큐를 배열로 6개 생성하면 될 것 같긴함
(1 ≤ N ≤ 500,000, 2 ≤ P ≤ 300,000)


 N, P
 A[6]
 result = 0


 for(n번 만큼){
     입력
     if (입력 받은 프렛이 == A[line].peek()) continue;
     else if (입력 받은 프렛이 > A[line].peek()) result++;
     else {
         while(!A.isEmpty() &&입력 받은 프렛이 < A[line].peek()){
             A[line].pop();
             result++;
         }
         result++;
     }
 }

*/
