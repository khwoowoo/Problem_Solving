import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long A[] = new long[N + 1];

        A[1] = 1;
        A[2] = 2;

        for(int i = 3; i < N + 1; i++){
            A[i] = (A[i - 1] + A[i - 2]) % 10007;
        }
        
        System.out.println(A[N]);
    }
}
