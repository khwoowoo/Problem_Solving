import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i < N + 1; i++) deque.addLast(i);


        while (deque.size() > 1) {
            if(A == 1) deque.pollFirst();
            else deque.addLast(deque.pollFirst());
            A = A * -1;
            //System.out.println(deque.toString());
        }

        System.out.println(deque.peekFirst());
    }
}

/*
시간 2초
1~N까지 카드가 순서대로 있음 (1~50만)
연산 두 가지를 반복
 - 버리기
 - 맨밑에 넣기
제일 마지막에 있는 카드 출력

이건 자료구조이용한 방법이고 간단하게 N번 수행하면 될듯?
자료구조는 덱이 좋아보인다 앞에서 버리고 뒤에서 넣고

N 입력
홀짝 변수
for 1 to N + 1: 덱 초기화

while 덱 사이즈가 1이 될 때까지:
if 홀수이면 버리기
elif 짝수으면 맨뒤에 넣기

마지막 출력
*/
