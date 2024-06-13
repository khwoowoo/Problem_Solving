/*
DP는 무조건 종이다...
주석으로 한 계가 있다....
종이 췌고...
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][] = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < M; i++){A[0][i] += A[0][i - 1];}
        for(int i = 1; i < N; i++){A[i][0] += A[i - 1][0];}

        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                A[i][j] += Math.max(A[i - 1][j - 1], Math.max(A[i][j - 1], A[i - 1][j]));
            }
        }
        System.out.print(A[N - 1][M - 1]);
    }
}
