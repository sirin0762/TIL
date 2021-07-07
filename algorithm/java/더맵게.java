// 최소 힙, 최대 힙 => priorityQUeue로 구현
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. 최소 힙 구현, 원소 추가
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int count = 0;
        
        for(int i = 0; i < scoville.length; i++){
            q.offer(scoville[i]);
        }
        
        while(q.size() > 1 && q.peek() < K){
            int min = q.poll();
            
            q.offer(min + 2 * q.poll());
            count += 1;
        }
        if(q.size() <= 1 && q.peek() < K){
            return -1;
        }
        return count;
    }
}
