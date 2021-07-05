// 이 문제는 아이디어가 중요하다. 3진법이라고 나머지가 0이면 0 대신 4를 넣는 방식이 아닌 최초 배열을 선언해줌으로써 더 쉬운 동작이 가능하다.
// String은 immutable 하기 때문에 String 끼리의 연산은 메모리 할당과 해제를 하여 시간이 오래걸린다. 만약 String 연산을 해야한다면 StringBuilder 클래스를 이용하여(sb는 mutable) 계산해라 

class Solution {
    public String solution(int n) {
        StringBuilder answer =  new StringBuilder();
        char[] arr = {'4', '1', '2'};
        
        while(n > 0){
            int r = n % 3;
            answer.append(arr[r]);
            n = n / 3;
            
            if(r == 0){
                n -= 1;
            }
        }    
        
        return answer.reverse().toString();
    }
}
