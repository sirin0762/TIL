import java.util.*;
class FailRate implements Comparable<FailRate> {
    private int stage;
    private double failRate;
    
    public FailRate(int stage, double failRate){
        this.stage = stage;
        this.failRate = failRate;
    }
    
    public int getStage(){
        return this.stage;
    }
    
    public double getFailRage() {
        return this.failRate;
    }
    
    public String toString() {
        return "stage : " + this.stage + ", " + "failRate : " + this.failRate; 
    }
    
    @Override
    public int compareTo(FailRate other){
        if(this.failRate == other.failRate){
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.failRate, this.failRate);
    }
}

class Solution {
    
    public int stageCount(int[] stages, int x){
        int count = 0;
        for(int i = 0; i < stages.length; i++){
            if(stages[i] > x) return count;
            if(stages[i] == x) count++;         
        }
        return count;
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int length = stages.length;
        List<FailRate> rates = new ArrayList<>();
        Arrays.sort(stages);
        
        int i = 1;
        while(i <= N){
            int cnt = stageCount(stages, i);
            double fail = 0;
            if(length >= 1){
                fail = (double) cnt / length;
            }
            
            rates.add(new FailRate(i, fail));
            length -= cnt;
            i++;
        }
                      
        Collections.sort(rates);
        
        for(int j = 0; j < N; j++){
            answer[j] = rates.get(j).getStage();
        }
        return answer;
    }
}
