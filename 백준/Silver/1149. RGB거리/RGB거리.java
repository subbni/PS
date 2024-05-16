import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cost; 
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N+1][3]; // 0-빨, 1-초, 2-파
        memo = new int[N+1][3]; 
        StringTokenizer st;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        memo[1][0] = cost[1][0];
        memo[1][1] = cost[1][1];
        memo[1][2] = cost[1][2];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            dp(N,i);
            if(min > memo[N][i]) min = memo[N][i];
        }
        System.out.println(min);
    }

    static void dp(int idx, int color) {
        if(memo[idx][color]!=0) return;

        dp(idx-1,(color+1)%3);
        dp(idx-1,(color+2)%3);
        memo[idx][color] = cost[idx][color] + Math.min(memo[idx-1][(color+1)%3],memo[idx-1][(color+2)%3]);
    }
}
