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
