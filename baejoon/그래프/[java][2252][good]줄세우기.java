import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class TopologicalSort{
        private int V;
        private List<List<Integer>> adj;

        public TopologicalSort(int v){
            this.V = v;
            adj = new ArrayList<>();

            for(int i = 0; i < v; i++) adj.add(new ArrayList<>());
        }

        void addEdge(int v, int w){
            adj.get(v).add(w);
        }

        void topologicalSort(){
            int[] indegree = new int[V];

            for(int i = 0; i < V; i++){
                List<Integer> temp = adj.get(i);
                for(int node: temp){
                    indegree[node]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < V; i++){
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }

            List<Integer> topOrder = new ArrayList<Integer>();
            
            while (!queue.isEmpty()) {
                int u = queue.poll();
                topOrder.add(u);

                for(int node : adj.get(u)){
                    if(--indegree[node] == 0){
                        queue.add(node);
                    }
                }
            }

            for (int i : topOrder) {
                System.out.print((i + 1) + " ");
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TopologicalSort ts = new TopologicalSort(N);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            ts.addEdge(node1, node2);
        }

        ts.topologicalSort();
    }
}
