import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split("-");
        int result = 0;

        
        for(int i = 0; i < A.length; i++){
            int sum = getSum(A[i]);
            if (i == 0){ result += sum;}
            else { result -= sum;}
        }
            
        System.out.println(result);
    }

    public static int getSum(String str){
        String[] temp = str.split("[+]");
        int sum = 0;

        for(int j = 0; j < temp.length; j++){
            sum += Integer.parseInt(temp[j]);
        }
        
        return sum;
    }
}
