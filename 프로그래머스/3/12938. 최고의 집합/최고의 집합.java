import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] dp;        
        if(n>s) {
            dp = new int[] {-1};
        } else {
            dp = new int[n];
            int idx = 0;
            while(n>0) {
                dp[idx++] = s/n;
                s= (s-s/n);
                n--;
            }
        }
        Arrays.sort(dp);
        return dp;
    }
}