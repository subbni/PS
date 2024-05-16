import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static int[][] matrix;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            matrix = new int[N+1][N+1];
            visited = new boolean[N+1];
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                matrix[v1][v2] = 1;
                matrix[v2][v1] = 1;
            }
            int max = 1;
            for(int i=1; i<=N; i++) {
                max = Math.max(max, dfs(i));
            }

            sb.append("#"+t+" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
    static int dfs(int idx) {
        visited[idx] = true;
        int max = 1;
        for(int i=1; i<=N; i++) {
            if(visited[i] || matrix[idx][i]<=0) continue;
            max = Math.max(max,dfs(i)+1);
        }
        visited[idx] = false;
        return max;
    }
}
