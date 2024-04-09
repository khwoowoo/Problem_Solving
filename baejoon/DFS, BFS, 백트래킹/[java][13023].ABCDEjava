import java.util.*;
import java.io.*;

class Main {
    private static int N, M;
    private static List<List<Integer>> graph;
    private static boolean[] checked;

    public static void DFS(int start, int depth) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
        }

        checked[start] = true;
        for (int next : graph.get(start)) {
            if (!checked[next]) {
                DFS(next, depth + 1);
            }
        }
        checked[start] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int i = 0; i < N; i++) {
            checked = new boolean[N];
            DFS(i, 1);
        }

        System.out.println(0);
    }
}
