import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N + 1];
        int start = 1;
        int end = 1;
        int count = 0;

        for(int i = 0; i < N + 1; i++) A[i] = i;
        
        int sum = A[start];
        while(start <= end){
            if (sum == N){ count++;  sum -= A[start++]; }
            else if(sum < N){ sum += A[++end];}
            else{sum -= A[start++];}
             // System.out.println(String.format("%d %d", start, end));
        }

        System.out.println(count);
    }
}
