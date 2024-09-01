import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static List<List<Integer>> A;
    public static boolean[] checked ;
    public static void DFS(int start){
        checked[start] = true;

        for(Integer node : A.get(start)){
            if(checked[node] == false){
                DFS(node);
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        A = new ArrayList<>();
        checked = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            A.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            A.get(node1).add(node2);
            A.get(node2).add(node1);
        }

        DFS(1);

        int count = 0;
        for(int i = 1; i < N + 1; i++){
            if(checked[i] == false){
                count++;
            }
        }

        System.out.print(N - 1 - count);
    }
}

/*
연결 요소의 개수를 구하는 아주 간단한 문제
*/
