import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int start = 0, end = N - 1, count = 0;
            
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        
        while (start < end) {
            int cur = A[start] + A[end];
        
            if(cur == M) {count++; start++; end--;}
            else if(cur < M) start++;
            else end--;
        }
        System.out.println(count);
    }
}

/*
2초
더 해서 M를 찾는 문제
이거는 정렬하고 투포인터를 이용한 방법을 사용하면 될듯
1 2 3 4 5 7
1 7
2 7 -> 찾음
3 5
4 5

더한 숫자가 M보다 작으면 앞에 이동
더한 숫자가 M보다 크면 뒤에서 이동

N, M
A(정렬)
start, end
count

while (start < end) {
    cur = A[start] + A[end]

    if(cur == M) count++; start++; end++;
    else if(cur < M) start++;
    else end++;
}
*/



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
