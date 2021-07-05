// 망할 자료구조, queue 에서는 왠지 모르겠지만 get을 통한 원소 접근이 안된다. 
import java.util.*;

class Solution {
    public int[] solution(int[] p, int[] s) {
        
        Stack<Integer> needDays = new Stack<>();
        for(int i = p.length - 1; i >= 0; i--){
            needDays.add((100 - p[i]) / s[i] + ((100 - p[i]) % s[i] > 0 ? 1 : 0));
        }
        
        List<Integer> distDays = new ArrayList<>();
        while(!needDays.isEmpty()){
            int cnt = 1;
            
            int top = needDays.pop();
            
            while(!needDays.isEmpty() && top >= needDays.peek()){
                cnt++;
                needDays.pop();
            }
            distDays.add(cnt);           
        }
        
        int[] answer = new int[distDays.size()];
        for(int i = 0; i < distDays.size(); i++){
            answer[i] = distDays.get(i);
        }
        
        return answer;
    }
}
