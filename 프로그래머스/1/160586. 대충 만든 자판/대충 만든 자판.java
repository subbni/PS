import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> minMap = new HashMap<Character,Integer>();
        for(char c='A'; c<='Z'; c++) {
            minMap.put(c, -1);
        }
        // 각 알파벳 당 최소 키 횟수 Map 구성
        for(int i=0; i<keymap.length; i++) {
          char[] chars = keymap[i].toCharArray();
          for(int j=0; j<chars.length; j++) {
            int curVal = minMap.get(chars[j]);
            if(curVal==-1 || curVal>j+1) {
              minMap.put(chars[j], j+1);
            }
          }
        }

        for(int i=0; i<targets.length; i++) {
          int cnt = 0;
          char[] chars = targets[i].toCharArray();
          for(int j=0; j<chars.length; j++) {
            int minVal = minMap.get(chars[j]);
            if(minVal == -1) {
              cnt = -1;
              break;
            }
            cnt += minVal;
          }
          answer[i] = cnt;
        }
        
        return answer;
    }
}