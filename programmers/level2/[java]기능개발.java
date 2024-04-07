import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {     
        int first = 0;
        int N = progresses.length;
        List<Integer> list = new ArrayList<>();

        while (first < N){
            for(int i = first; i < N; i++) progresses[i] += speeds[i];
            if(progresses[first] >= 100){
                int count = 0;
                while (first < N && progresses[first] >= 100) {
                    count++; first++;
                }
                
                if (count != 0) list.add(count);
                //System.out.println(String.format("%s %d", Arrays.toString(progresses), first));
            }
        }
        return list;
    }
}

/*
93 30 55
100 240 90

first = 0

while:
    for 배열의 길이 만큼 반복: progresses[i] += speeds[i]
    
    if progresses[first]가 100 넘었는지 확인: 
        first부터 100넘은거 확인 후 개수 카운팅
        개수 리스트에 넣기
        first 위치 변경인데 first가 맨 마지막였으면 종료
*/
