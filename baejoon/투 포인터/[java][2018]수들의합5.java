import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int start= 1;
        int end = 1;
        int sum = 1;
        int count = 1;
        int[] A = new int[target + 1];
        for(int i = 1; i < target + 1; i++) A[i] = i;

        while(start < target && end < target){
            if(sum == target) {count += 1; sum -= A[start]; start += 1; }
            else if(sum < target) {end += 1; sum += A[end];}
            else if(sum > target) {sum -= A[start]; start += 1; }
        }
        System.out.println(count);
    }
}
