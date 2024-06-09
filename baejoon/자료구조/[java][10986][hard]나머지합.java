import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N + 1]; 
        long[] C = new long[M]; 
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = ((S[i - 1] + Integer.parseInt(st.nextToken())) % M); 
            if (S[i] == 0) result++; 
            C[(int)(S[i])]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                result += (C[i] * (C[i] - 1)) / 2; 
            }
        }

        System.out.print(result);
    }
}
