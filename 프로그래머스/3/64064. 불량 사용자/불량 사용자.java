import java.util.*;

class Solution {
    static ArrayList<HashSet<Integer>> matchingIdList;
    static int[] bannedIdComb;
    static HashSet<String> uniqueCombinations = new HashSet<>();
    static String[] bannedIdArr;
    static String[] userIdArr;
    static boolean[] visited;

    public static int solution(String[] user_id, String[] banned_id) {
        bannedIdArr = banned_id;
        userIdArr = user_id;
        matchingIdList = new ArrayList<>();
        bannedIdComb = new int[bannedIdArr.length];
        
        // 각 banned_id에 맞는 user_id를 찾는 과정 최적화
        for (String bannedId : banned_id) {
            HashSet<Integer> matchedUsers = new HashSet<>();
            for (int j = 0; j < user_id.length; j++) {
                if (isMatch(user_id[j], bannedId)) {
                    matchedUsers.add(j);
                }
            }
            matchingIdList.add(matchedUsers);
        }

        visited = new boolean[userIdArr.length];
        findPossibleBannedIds(0);

        return uniqueCombinations.size();
    }

    // 두 문자열이 일치하는지 검사하는 메서드
    private static boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    // 가능한 banned_id 조합을 찾는 메서드
    private static void findPossibleBannedIds(int curIdx) {
        if (curIdx == bannedIdArr.length) {
            // 조합을 정렬하여 고유하게 관리
            int[] sortedComb = Arrays.copyOf(bannedIdComb, bannedIdComb.length);
            Arrays.sort(sortedComb);
            uniqueCombinations.add(Arrays.toString(sortedComb));
            return;
        }
        
        for (int i : matchingIdList.get(curIdx)) {
            if (!visited[i]) {
                visited[i] = true;
                bannedIdComb[curIdx] = i;
                findPossibleBannedIds(curIdx + 1);
                visited[i] = false;
            }
        }
    }
}