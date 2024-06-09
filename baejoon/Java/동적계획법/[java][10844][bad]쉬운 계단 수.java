import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M[][] = new long[N + 1][10];

        for(int i = 1; i < 10; i++){ M[1][i] = 1;}

        for(int i = 2; i <= N; i++){
            M[i][0] = M[i - 1][1];
            M[i][9] = M[i - 1][8];

            for(int j = 1; j <=8; j++){
                M[i][j] = (M[i - 1][j + 1] + M[i - 1][j - 1]) % mod;
            }
        }

        long result = 0;

        for(int i = 0; i < 10; i++){
            result += M[N][i];
            result %= mod;
        }

        System.out.print(result);
    }
}
