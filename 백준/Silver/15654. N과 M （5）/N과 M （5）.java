import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // N개의 자연수 중에서
        M = Integer.parseInt(st.nextToken());  // M개를 고른 수열을 구하라.
        arr = new int[N];
        ans = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        dfs(0,0);
        
        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if(depth == M) {
            for(int val: ans) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                dfs(i+1,depth+1);
                visited[i] = false;
            }
        }
        
    }
}
