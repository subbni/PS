public class Solution {
    static boolean[] visited;
    static int[][] connected;

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        connected = computers;
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        for(int i=0; i<connected.length; i++) {
            if(connected[idx][i]==1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
