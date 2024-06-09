import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(sk.nextToken());
        int P = Integer.parseInt(sk.nextToken());
        
        String A = br.readLine();
        
        Map<Character, Integer> infoMap = new HashMap<>(); // 필수 개수
        Map<Character, Integer> curMap = new HashMap<>(); // 현재 개수
        
        sk = new StringTokenizer(br.readLine());
        infoMap.put('A', Integer.parseInt(sk.nextToken())); curMap.put('A', 0); 
        infoMap.put('C', Integer.parseInt(sk.nextToken())); curMap.put('C', 0); 
        infoMap.put('G', Integer.parseInt(sk.nextToken())); curMap.put('G', 0); 
        infoMap.put('T', Integer.parseInt(sk.nextToken())); curMap.put('T', 0);

        int count = 0;
        int start = 0;
        //초기화
        for(int i = 0; i < P; i++){
            char key = A.charAt(i);
            curMap.put(key, curMap.get(key) + 1);
        }
        
        if(infoMap.get('A') <= curMap.get('A') && infoMap.get('C') <= curMap.get('C') && 
              infoMap.get('G') <= curMap.get('G') && infoMap.get('T') <= curMap.get('T')) {
                count++;
              }

        for(int i = P; i < A.length(); i++){
            char char_end = A.charAt(i);
            char char_start = A.charAt(start);
            curMap.put(char_end, curMap.get(char_end) + 1);
            curMap.put(char_start, curMap.get(char_start) - 1);
            start++;
            
            if(infoMap.get('A') <= curMap.get('A') && infoMap.get('C') <= curMap.get('C') && 
              infoMap.get('G') <= curMap.get('G') && infoMap.get('T') <= curMap.get('T')) {
                count++;
              }
        }


        // System.out.println(infoMap.toString());
        // System.out.println(curMap.toString());
        System.out.println(count);
    }
}

/*
S = 전체 문자열 길이
P = 부분 문자열 길이
2초 -> nlogn 이하

012345678
CCTGGATTG

방법 1:
S[start:start + P]씩 확인하는 방법
확인할 때 문자열 개수 확인해야 되서
N**2임. X

방법2:
슬라이딩 윈도우 GOOD

sudo

S, P, 문자열, 개수 입력 처리
Start = 0
end = P - 1
해쉬맵 두 개 생성

for(P to S의 길이){
    검사
    이동 및 해쉬맵에 값 수정
}
*/
