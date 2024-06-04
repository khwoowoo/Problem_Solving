/*
왠만해서 Long이 좋은 듯하고
투 포인터를 이런식으로 사용할 수 있어야 한다..
시간이 짧은데 많은 탐색이 이루어져야 한다면
투포인터나 슬라이드윈도우를 생각하면 좋은 듯!
*/

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long A[] = new long[N];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Long.parseLong(st.nextToken());

        Arrays.sort(A);
        for(int i = 0; i < N; i++){
            long target = A[i];
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if(A[start] + A[end] == target){
                    if(start != i && end != i) {
                        count++; break;
                    }
                    else if (start == i) start++;
                    else end--;
                }
                else if (A[start] + A[end] < target){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}
