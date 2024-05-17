import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] stuff;
    static Integer[][] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stuff = new int[N][2];
        dp = new Integer[N][K+1]; // 1~k 무게 까지 넣을 때, 인덱스 n까지의 물건 중 선택하여 얻을 수 있는 최대 가치
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken()); // 무게       
            stuff[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }
        System.out.println(knapsack(N-1,K));
    }

    static int knapsack(int idx, int weight) {
        if(idx < 0) return 0;

        if(dp[idx][weight] == null) {
            if(stuff[idx][0] > weight) {
                dp[idx][weight] = knapsack(idx-1, weight);
            } else {
                dp[idx][weight] = Math.max(knapsack(idx-1, weight-stuff[idx][0])+stuff[idx][1],knapsack(idx-1, weight));
            }
        }
        return dp[idx][weight];
    }
}
