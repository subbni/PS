import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] max = new int[triangle.length][triangle.length];
        
        for(int i = 0; i < triangle.length; i++) {
            max[triangle.length-1][i] = triangle[triangle.length-1][i];
        }

        for(int i = triangle.length-2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                max[i][j] = triangle[i][j] + Math.max(max[i+1][j],max[i+1][j+1]);
            }
        }

        return max[0][0];
    }
}