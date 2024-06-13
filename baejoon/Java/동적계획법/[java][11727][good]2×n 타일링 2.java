import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[] = new long[1001];

        D[1] = 1; D[2] = 3;
        for(int i = 3; i < N + 1; i++){
            D[i] = D[i - 1] + (D[i - 2] * 2);
            D[i] %= 10007;
        }
        
        System.out.println(D[N]);
    }
}
