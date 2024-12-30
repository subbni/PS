import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            answer[i] = players[i];
            hm.put(players[i],i);
        }
        for(int i=0; i<callings.length; i++) {
            String calledName = callings[i];
            // 현재 불린 사람 등수 찾기
            int idx = hm.get(calledName);
            // 추월당한 사람 이름 찾기
            String behind = answer[idx-1];
            // map 수정
            hm.replace(calledName,idx-1);
            hm.replace(behind,idx);
            // answer 배열 수정
            answer[idx] = behind;
            answer[idx-1] = calledName;
        }
        
        return answer;
    }
}