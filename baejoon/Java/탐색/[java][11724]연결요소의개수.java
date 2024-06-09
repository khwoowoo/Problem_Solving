import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int count = 0;
    public static void DFS(List<List<Integer>> graph, boolean[] check, int start) {
        if (check[start]) {
            return;
        }

        check[start] = true; // 현재 노드를 방문 처리
        for (int next : graph.get(start)) { // 현재 노드의 모든 인접 노드에 대해
            if (!check[next]) { // 아직 방문하지 않은 노드가 있다면
                DFS(graph, check, next); // 재귀적으로 DFS 수행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 그래프 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()); // 재사용하기 위해 새로운 StringTokenizer 객체 생성
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph.get(y).add(x); // 양방향 그래프가 아니라면, 한 방향으로만 추가
            graph.get(x).add(y); // 양방향 그래프인 경우, 반대 방향도 추가
        }

        for (int i = 1; i <= N; i++) {
            if(!check[i]) {
                DFS(graph, check, i);
                count++;
            }
        }
        System.out.println(count);
    }
}


/*
DFS 사용

그래프 연결하기
체크 배열 생성하기
count(연결 요소 체크) = 1

function dfs
    여기서 아직 다 안 돌았는데
    스택에 요소가 다 끝났다면 카운트 + 1

*/
