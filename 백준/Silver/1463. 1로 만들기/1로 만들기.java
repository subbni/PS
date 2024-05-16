import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        memo[0] = memo[1] = 0;
        System.out.println(dp(N));
    }

    static int dp(int n) {
        if(n<=1 || memo[n]>0) {
            return memo[n];
        } 

        if(n%6 == 0) {
            memo[n] = 1 + Math.min(dp(n/3),dp(n/2));
        } else if(n%3 == 0) {
            memo[n] = 1 + Math.min(dp(n/3),dp(n-1));
        } else if(n%2 == 0) {
            memo[n] = 1 + Math.min(dp(n/2),dp(n-1));
        } else {
            memo[n] = 1 + dp(n-1);
        }
        return memo[n];
    }
}
