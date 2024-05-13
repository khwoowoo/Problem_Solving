import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] A = new int[X + 1];

        if(X == 1){
            System.out.println(0); return;
        }
        else if (X < 4) {
            System.out.println(1); return;
        }

        A[2] = 1;  A[3] = 1;
        for (int i = 4; i <= X; i++) {
            A[i] = A[i - 1] + 1; /
            if (i % 2 == 0) A[i] = Math.min(A[i], A[i / 2] + 1); 
            if (i % 3 == 0) A[i] = Math.min(A[i], A[i / 3] + 1); 
        }


        System.out.println(A[X]);
    }
}
