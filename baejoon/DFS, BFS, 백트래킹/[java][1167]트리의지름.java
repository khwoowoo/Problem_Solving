/*
나는 이거 문제 보고 DFS로 풀면 끝인데? 생각했고 예제까지 잘 나와서
잘 풀었다고 생각했는데 아니네...

DFS/BFS를 두 번 사용해야 되는 문제네...

첫 번째로 임의로 시작한 노드가 루트인지 몰라서 끝까지간 다음
거기서 찾아야 하는 문제이기 때문이다....
*/

import java.util.*;
import java.io.*;

class Main {
    static List<List<int[]>> graph;
    static boolean[] checked;
    static int furthestNode = 0;
    static int maxDistance = 0;

    public static void DFS(int start, int dis) {
        if (checked[start]) return;

        checked[start] = true;
        if (dis > maxDistance) {
            maxDistance = dis;
            furthestNode = start;
        }

        for (int[] edge : graph.get(start)) {
            if (!checked[edge[0]]) {
                DFS(edge[0], dis + edge[1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        checked = new boolean[V + 1];

        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            while (true) {
                int connectedNode = Integer.parseInt(st.nextToken());
                
                if (connectedNode == -1) break;
                
                int distance = Integer.parseInt(st.nextToken());
                graph.get(node).add(new int[]{connectedNode, distance});
            }
        }

        checked = new boolean[V + 1];
        DFS(1, 0);


        checked = new boolean[V + 1];
        maxDistance = 0;
        DFS(furthestNode, 0);

        System.out.println(maxDistance);
    }
}
