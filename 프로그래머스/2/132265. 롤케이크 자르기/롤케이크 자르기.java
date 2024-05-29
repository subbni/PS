import java.util.HashSet;

public class Solution {
    public int solution(int[] topping) {
        int[] frontArr = new int[topping.length];
        int[] backArr = new int[topping.length];
        HashSet<Integer> hs = new HashSet<>();
        int cnt = 0;
        for(int i=0; i<topping.length; i++) {
            if(!hs.contains(topping[i])) { // 처음 나온 토핑 종류
                hs.add(topping[i]);
                frontArr[i] = ++cnt;
            } else {
                frontArr[i] = cnt;
            }
        }
        hs = new HashSet<>();
        cnt = 0;
        for(int i=topping.length-1; i>=0; i--) {
            if(!hs.contains(topping[i])) { // 처음 나온 토핑 종류
                hs.add(topping[i]);
                backArr[i] = ++cnt;
            } else {
                backArr[i] = cnt;
            }
        }

        int answer = 0;
        for(int i=0; i+1<topping.length;i++) {
            if(frontArr[i]==backArr[i+1]) {
                answer++;
            }
        }
        return answer;
    }
}
