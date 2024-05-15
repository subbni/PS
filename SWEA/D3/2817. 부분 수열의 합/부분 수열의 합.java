import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N,K;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            dfs(0,0);
            sb.append("#"+t+" ").append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int sum) {
        if(sum == K) {
            cnt++;
            return;
        }
        for(int i=idx; i<N; i++) {
            if(sum + arr[i] <= K) {
                dfs(i+1,sum+arr[i]);
            }
        }
    }
}
