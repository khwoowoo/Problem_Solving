/*
dp 접근 방식
큰 문제를 작은 문제로 변경하기
일단 N번째 까지는 다 구했다고 생각하기
dp 테이블 정의
점화식 작성..

어렵다...

dp[i][0]: i번 집까지 0번색으로 칠할 때 최소 비용
*/
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[][] = new int[N][3];
        int D[][] = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Integer.parseInt(st.nextToken());
        }

        D[0][0] = A[0][0];D[0][1] = A[0][1];D[0][2] = A[0][2];
        for(int i = 1; i < N; i++){
            D[i][0] = Math.min(D[i - 1][1], D[i - 1][2]) + A[i][0];
            D[i][1] = Math.min(D[i - 1][0], D[i - 1][2]) + A[i][1];
            D[i][2] = Math.min(D[i - 1][0], D[i - 1][1]) + A[i][2];
        }

        System.out.print(Math.min(Math.min(D[N - 1][0], D[N - 1][1]), D[N - 1][2]));
    }
}
