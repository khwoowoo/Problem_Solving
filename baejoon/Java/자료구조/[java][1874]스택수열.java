import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N + 1];
        int idx = 1;
        int cur = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); 

        for(int i = 1; i < N + 1; i++) A[i] = Integer.parseInt(br.readLine());
        
        stack.push(cur++);sb.append("+\n");
        while (idx < N + 1 && cur <= (N + 1)) {
            if (!stack.isEmpty() && stack.peek() == A[idx]) {stack.pop(); idx++; sb.append("-\n");}
            else {stack.push(cur++); sb.append("+\n");}
            //System.out.println(String.format("%s %s",stack.toString(), Arrays.toString(A)));
        }

        if(!stack.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());
    }
}
