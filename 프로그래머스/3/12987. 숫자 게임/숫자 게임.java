import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idxA = 0, idxB = 0;
        // a원소보다 큰 b원소 찾기
        while(idxB < B.length) {
            if(A[idxA] >= B[idxB]) {
                idxB++;
            } else {
                answer++;
                idxB++;
                idxA++;
            }
        }        
        return answer;
    }
}