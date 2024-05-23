//다시 풀어보기

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int A[][];
    static int N, M;
    static int moveX[] = {0, 1, -1, 0};
    static int moveY[] = {1, 0, 0, -1};

    static class Node{
        int x;
        int y;
        int z;

        Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static boolean isRange(int x, int y){
        return (0 <= x && x <N && 0 <= y && y < M);
    }

    public static int BFS(){
        A[0][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int x = node.x + moveX[i];
                int y = node.y + moveY[i];
                
                if(x == N -1 && y == M -1) {
                    return node.z + 1;
                }                     
                else if(isRange(x, y) && A[x][y] == 1){
                    queue.add(new Node(x, y, node.z + 1));
                    A[x][y] = 0;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                A[i][j] = temp.charAt(j) - '0';
            }
        }
        System.out.print(BFS());
    }
}

import java.util.*;
import java.io.*;

class Main {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] check;
    static int N, M;

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        check[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            if (cy == N - 1 && cx == M - 1) { // 목적지에 도달한 경우
                System.out.println(map[cy][cx]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 1 && !check[ny][nx]) {
                    check[ny][nx] = true;
                    map[ny][nx] = map[cy][cx] + 1; // 경로의 길이를 갱신
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }
}
