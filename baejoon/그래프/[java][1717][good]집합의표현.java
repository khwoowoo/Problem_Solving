import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class UnionFind{
        private int[] parent;
        private int[] rank;

        public UnionFind(int size){
            parent = new int[size];
            rank = new int[size];

            for(int i = 0; i < size; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p){
            if(parent[p] != p){
                parent[p] = find(parent[p]);
            }

            return parent[p];
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP != rootQ){
                if(rank[rootP] < rank[rootQ]){parent[rootP] = rootQ;}
                else if(rank[rootP] > rank[rootQ]){parent[rootQ] = rootP;}
                else{
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
            }
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        UnionFind uf = new UnionFind(N + 1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(oper == 0){
                uf.union(a, b);
            }
            else{
                if(uf.connected(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        
    }
}
