// HashMap의 기본적인 사용법, 문자열 연산은 왠만하면 StringBuilder 를  이용
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> maps = new HashMap<>();
        ArrayList<String> chatLogs = new ArrayList<>();
        
        for(String log: record){
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = "";
            
            if(!command.equals("Leave")){
                nickname = st.nextToken();
            }
            
            switch(command){
                    case("Enter"):
                        maps.put(userId, nickname);
                        chatLogs.add(userId + "님이 들어왔습니다.");
                        break;
                    case("Leave"):
                        chatLogs.add(userId + "님이 나갔습니다.");
                        break;
                    case("Change"):
                        maps.put(userId, nickname);
                        break;
            }
        
        }
        
        String[] answer = new String[chatLogs.size()];      
        int logIdx = 0;
        
        for(String str: chatLogs){
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);
            
            answer[logIdx++] = str.replace(userId, maps.get(userId));
        }
        return answer;
    }
}
