// dfs 로 구현
class Solution {
    
    public static int answer = 0;
    public static int length;
    
    public void dfs(int[] numbers, int level, int target, int value){
        if(level == length){
            if(value == target){
                answer += 1;
            }
            return;
        }
        
        dfs(numbers, level + 1, target, value + numbers[level]);
        dfs(numbers, level + 1, target, value - numbers[level]);
    }
    
    
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        
        dfs(numbers, 0, target, 0);
        return answer;
    }
}
