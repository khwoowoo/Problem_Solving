//long을 생활화 하자..

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][N + 1];
        long[][] D = new long[N + 1][N + 1]; 

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D[1][1] = 1; // Start path count from the first cell
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (A[i][j] == 0 || D[i][j] == 0) continue; 

                int posX = j + A[i][j];
                int posY = i + A[i][j];

                if (posX <= N) D[i][posX] += D[i][j];
                if (posY <= N) D[posY][j] += D[i][j];
            }
        }

        System.out.print(D[N][N]); 
    }
}
