import java.util.*;

class Solution {
    static ArrayList<HashSet<Integer>> matchingIdList;
    static char[] bannedIdComb;
    static ArrayList<String> bannedIdCombList = new ArrayList<String>();
    static String[] bannedIdArr;
    static String[] userIdArr;
    static boolean[] visited;

    static public int solution(String[] user_id, String[] banned_id) {
        bannedIdArr = banned_id;
        userIdArr = user_id;
        matchingIdList = new ArrayList<HashSet<Integer>>();
        bannedIdComb = new char[bannedIdArr.length];
        for(int i=0; i<banned_id.length; i++) {
            matchingIdList.add(new HashSet<>());
            String bannedId = banned_id[i];
            for(int j=0; j<user_id.length; j++) {
                char[] userIdChar = user_id[j].toCharArray();
                for(int k=0; k<Math.min(userIdChar.length, bannedId.length()); k++) {
                    if(bannedId.charAt(k) == '*') {
                        userIdChar[k] = '*';
                    }
                }
                String str = new String(userIdChar);
                if(str.equals(bannedId)) {
                    matchingIdList.get(i).add(j);
                }
            }
        }
        visited = new boolean[userIdArr.length];
        findPossibleBannedIds(0);
        HashSet<String> hs = new HashSet<>();
        for(String sb : bannedIdCombList) {
          char[] charArr = sb.toCharArray();
          Arrays.sort(charArr);
          hs.add(new String(charArr));
        }

        int answer = hs.size();
        return answer;
    }
    
    static public void findPossibleBannedIds(int curIdx) {
        if(curIdx == bannedIdArr.length) {
          bannedIdCombList.add(new String(bannedIdComb));
          return;
        }
        
        for(int i=0; i<userIdArr.length; i++) {
            if(!visited[i] && matchingIdList.get(curIdx).contains(i)) {
                visited[i] = true;
                bannedIdComb[curIdx] = (char)(i+'0');
                findPossibleBannedIds(curIdx+1);
                visited[i] = false;
            }
        }
    }
}