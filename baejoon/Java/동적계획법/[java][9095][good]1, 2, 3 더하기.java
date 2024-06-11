import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int D[] = new int[12];

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for(int i = 4; i < 12; i++){
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            System.out.println(D[N]);
        }
    }
}
