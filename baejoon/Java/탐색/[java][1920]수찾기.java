import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];

        StringTokenizer sk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){ A[i] = Integer.parseInt(sk.nextToken());}

        int M = Integer.parseInt(br.readLine());
        int B[] = new int[M];

        sk = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){ B[i] = Integer.parseInt(sk.nextToken());}

        Arrays.sort(A);

        for(int i = 0; i < M; i++){
            Boolean isFind = (Arrays.binarySearch(A, B[i]) > -1);
            if(isFind) System.out.println(1);
            else System.out.println(0);
            // System.out.println(Arrays.binarySearch(A, B[i]));
        }

        // System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(B));
        // System.out.println("Hello world!");
    }
}

/*
시간 1초

이진탐색를 여러 번 하면 될듯?
최악으로 10만개의 숫자를 10만번 찾아야 하는데 N * logN이고
정렬도있으나 nlogn이니 시간안에 가늘 할듯?
*/
