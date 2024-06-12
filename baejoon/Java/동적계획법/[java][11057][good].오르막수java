/*
정답을 맞추긴했지만 long, 마지막 결과의 합구할 때 나누기 때문에 여러 번 틀림
점화식은 맞았으나..
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[][] = new long[N][10];
        long result = 0;

        for(int i = 0; i < 10; i++){ D[0][i] = 1L; }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 10; j++){
                for(int k = j; k < 10; k++){
                    D[i][j] += (D[i - 1][k]) % 10007;
                }
            }
        }

        for(int i = 0; i < 10; i++){ result = (result + D[N - 1][i]) % 10007; }
        System.out.print(result);
        
    }
}
