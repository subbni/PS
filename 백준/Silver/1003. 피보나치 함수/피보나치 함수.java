import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            memo = new int[N+1][2];
            memo[0][0] = 1;
            memo[0][1] = 0;
            if(N>0) {
                memo[1][0] = 0;
                memo[1][1] = 1;
            }
            dp(N);
            sb.append(memo[N][0]+" "+memo[N][1]).append('\n');
        }
        System.out.print(sb);
    }

    static void dp(int idx) {
        if(memo[idx][0]!=0 || memo[idx][1]!=0) {
            return;
        }
        dp(idx-1);
        dp(idx-2);
        memo[idx][0] = memo[idx-1][0] + memo[idx-2][0];
        memo[idx][1] = memo[idx-1][1] + memo[idx-2][1];
    }

}
