import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        memo[1] = 1;
        if(N > 1) memo[2] = 2;
        System.out.println(dp(N));
    } 

    static int dp(int idx) {
        if(idx == 0 || memo[idx]!=0) return memo[idx];
        memo[idx] = (dp(idx-1) + dp(idx-2))%15746;
        return memo[idx];
    }
}
