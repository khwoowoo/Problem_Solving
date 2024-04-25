import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add((long) scoville[i]); 
        }

        long requiredScoville = K;
        while (pq.size() > 1 && pq.peek() < requiredScoville) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            pq.add(num1 + (num2 * 2));
            answer++;
        }

        if (pq.peek() < requiredScoville) return -1;

        return answer;
    }
}


/*
데이터를 작은거 매번 꺼내서 다시 삽입해야 함
그러면 매번 정렬하면 시간복잡도가 많이 올라가니

우선순위 큐를 사용해서 구하면 될듯?
그리고 맨 앞에 있는 숫자가 k 이상이면 종료하면 될듯?
*/
