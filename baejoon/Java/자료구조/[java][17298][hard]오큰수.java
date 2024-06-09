import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        int P[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
          while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                P[stack.peek()] = A[i];
                stack.pop();
            }
    
            stack.push(i); 
        }

        while(!stack.isEmpty()){
            P[stack.peek()] = -1;
            stack.pop();
        }
        
        for (int i = 0; i < N; i++) { sb.append(P[i] + " "); }
        System.out.print(sb.toString());
    }
}
