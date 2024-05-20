/*
일단 문제가 어려워서 해답 보고 했는데
출력 System.out.println으로 출력하니 시간 초과나와서
StringBuilder에 모아서 출력하는 방법으로 변경
많은 출력하는 알고리즘 문제는 한 번에 출력하는 방법을 찾아서 수행하는 것이 좋을 듯 ㅜㅜ
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Data {
        public int index;
        public int number;
    
        Data(int index, int number){
            this.index = index;
            this.number = number;
        }
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Data> A = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
        
            while(!A.isEmpty() && A.peekLast().number >= num){
                A.pollLast();
            }
        
            A.addLast(new Data(i, num));
        
            if(i - L >= A.peek().index){
                A.pollFirst();
            }
        
            output.append(A.peek().number).append(" ");
        }
        System.out.println(output.toString());


    }
}
