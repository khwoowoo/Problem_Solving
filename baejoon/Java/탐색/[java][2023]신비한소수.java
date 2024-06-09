/*
 문제 접근을 잘 했는데 살짝의 실수로 gpt가 알려줌
 일단 number = number * 10 + B[i] 반복문인데 값 갱신되는 걸 실수함,,,
 깊이 값은 그냥 매번 자리수 개산하는 코드 작성했는데 depth로 간편하게 끝,,,

 깊이 값은 그렇다치고 number = number * 10 + B[i] 너무 어이없고 초보적인 실수함,,
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int A[] = {2, 3, 5, 7};
    static int B[] = {1, 3, 5, 7, 9};

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void DFS(int number, int depth) {
        if (depth == N) {
            System.out.println(number);
            return;
        }

        for(int i = 0; i < 5; i++) {
            int temp = number * 10 + B[i];
            if (isPrimeNumber(temp)){
                //System.out.println(String.format("%d %d %d", temp, B[i], number));
                DFS(temp, depth + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < 4; i++){
            DFS(A[i], 1);
        }
    }
}

/*
2초
10,000,000 ~ 99,999,999 -> 2초안에 이걸 다 찾아보다는 것을 말이 안 됌
그리고 소수 구하는 방법으로 접근하면 안 될 것 같고
(제곱근 사용해서 이용하는 방법도 안 될 것 같은데?)
이게 전부 소수라는 것은? 
2 23 233 2333
첫 번째 숫자는 2 3 5 7 중 하나네?
두 번째 숫자는 '앞 숫자' + 1 3 5 7 9 중 하나네?
세 번째 숫자는 '앞 숫자' + 1 3 5 7 9 중 하나네?
네 번째 숫자는 '앞 숫자' + 1 3 5 7 9 중 하나네?

근데 시간 복잡도는 4 * 5**(N-1) 지수가 나오네

이런식으로 확장하는 방법으로 DFS구하면 될 것 같긴한데 끝에 도달하면 출력
2 3 9
23 3 9
29 3 
233
239


N(자리수)
A(2,3,5,7)
B(1, 3,5,7,9)

function dfs(number):
if 소수 판별: return;

if 자리수 판별: 출력 return;

for i(1 ~ 5):
temp = number * 10 + B[i]
if 소수 판별:
dfs(temp)
*/
