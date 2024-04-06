//투 포인터로 어떻게 해야 될지 모르겠어서 일단 다른 방법으로 성공함.이 방법은 O(nlogn)
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        int[] A;
        int count = 0;
        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

          for(int i = 0; i < N; i++) {
            int target = M - A[i];
            int index = Arrays.binarySearch(A, target);
            if (index >= 0 && index != i) { // 타겟을 찾았고, 현재 요소가 아닌 경우에만 카운트
                count++;
            }
        }
        
        System.out.println(count / 2); // 캐스팅 제거

    }
}
