import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] info;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N][2];
        dp = new int[N+1]; 
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // 기간
            info[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }
        for(int i=0; i<N; i++) {
            dp[i+1] = Math.max(dp[i],dp[i+1]);
            if(i+info[i][0] > N) continue;
            dp[i+info[i][0]] = Math.max(dp[i+info[i][0]], dp[i]+info[i][1]);
        }

        System.out.println(dp[N]);
    }
}
