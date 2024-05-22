import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> A = new ArrayDeque<>();
        boolean changed = false;
        
        for(int i = 1; i < N + 1; i++) A.addLast(i);
        
        while(A.size() >= 2){
            if(!changed) {
                A.pollFirst();
            } else{
                A.addLast(A.pollFirst());
            }
        
            changed = !changed;
            // System.out.println(A.toString());
        }

        System.out.println(A.pollFirst());
    }
}

/*
2초

N장의 카드가 있음
1~N까지 번호가 있음
1 ~ N 순서로 놓여있음

카드 한 장이 남을 때 까지 아래 반복
1. 제일 위에 있는 카드를 바닥에 버림
2. 제일 위에 있는 카드를 맨 밑에 옮김

걍 너무 간단한 문제

덱을 사용하면 간단하게 구현

changed = false
A(1~N까지 있는 덱)
while(A.size() >= 2){
    if(changed) {
        A.popFirst();
    } else{
        A.addLast(A.popFirst(););
    }

    changed = !changed;
}
*/
