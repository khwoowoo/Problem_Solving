import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int count = 0;

        for(int i = 0; i < operations.length; i++){
            if (operations[i].equals("D 1")) { 
                if (count == 1) {minHeap.clear(); maxHeap.clear(); count--;}
                else if (count > 0){ maxHeap.poll(); count--;}
            }
            else if (operations[i].equals("D -1")) {
                if (count == 1) {minHeap.clear(); maxHeap.clear(); count--;}
                else if (count > 0){ minHeap.poll(); count--;}
            }
            else{
                String[] temp = operations[i].split(" ");
                int data = Integer.parseInt(temp[1]);
                minHeap.add(data); maxHeap.add(data);
                count++;
            }
        }
        
        if(count == 0) return answer;
        
        answer[0] = maxHeap.peek();
        answer[1] = minHeap.peek();
        return answer;
    }
}

/*
우선 순위 큐를 사용하면 최대 힙, 최소 힙한다고 하면
하나는 구하기 쉬우나 반대 연산은 오래 걸림
다 꺼내서 다시 넣어야 함

그러면 두 개를 사용한다면?
1
1 2 3


두 개를 만들어서 최솟 힙, 최댓 힙 구현하고
minHeap.peek() <= maxHeap.peek() 상태를 계속 유지한다면 구할 수 있을 것 같음
근데 공간은 두 개로 사용됨 ㅋㅋㅋㅋㅋ 알빠누?

minHeap(최솟힙)
maxHeap(최댓힙)

for(operations 개수){
    if D 1이라면{maxHeap.poll();}
    else if D -1이라면{minHeap.poll();}
    else{
    temp = 문자열 스플릿(' ');
    minHeap.add(temp[1]);
    maxHeap.add(temp[1]);
    }
    
    if (minHeap.peek() <= maxHeap.peek()) {
        return answer;
    }
}
*/
