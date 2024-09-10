import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> hm = new HashMap<>();
        int[] answer = new int[photo.length];

        for(int i=0; i<name.length; i++) {
            hm.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                sum += hm.getOrDefault(photo[i][j],0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}