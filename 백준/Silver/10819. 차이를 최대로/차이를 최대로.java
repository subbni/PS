import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ans = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if(depth == N) {
            int result = 0;
            for(int i=1; i<N; i++) {
                result += Math.abs(ans[i-1]-ans[i]);
            }
            if(result > max) max = result;
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
