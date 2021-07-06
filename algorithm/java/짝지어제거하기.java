// 첫번쨰 시도, 정확성은 좋았으나, 효율성에서 꽝(느림)
import java.lang.*;

class Solution
{
    public int solution(String s)
    {   
        // 1. 버퍼 만들기
        StringBuilder str = new StringBuilder(s);
        int length = str.length();
        if(length % 2 == 1){
            return 0;
        }
        
        for(int i = 0; i < length / 2; i++){
            int j = 0;
            // 삭제할때마다 길이 갱신해야함
            while(j < str.length() - 1){
                if(str.charAt(j) == str.charAt(j + 1)){
                    if(str.length() == 2){
                        str.setLength(0);
                    }
                    else{
                        str.delete(j, j + 2);
                    }
                    break;
                }
                j++;
            }
        }
        
        if(str.length() == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}

// 답지 : stack을 통한 구현
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 1. 길이 선언 및 홀수인지 확인
        int length = s.length();      
        if(length % 2 == 1){
            return 0;
        }
        
        // 2, 스택 선언 및 문자열 순회
        Stack<String> stack = new Stack<>();    
        
        for(int i = 0; i < s.length(); i++){
            String now = String.valueOf(s.charAt(i));
            if(stack.isEmpty()){
                stack.push(now);
                continue;
            }
            
            String top = stack.peek();
            if(top.equals(now)){
                stack.pop();
            }
            else{
                stack.push(now);
            }                        
        }
        return stack.size() == 0? 1 : 0;
    }
}
