
import java.util.Scanner;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new Integer[n+1];
        dp[0]=dp[1]=0;

        System.out.println(func(n));
        in.close();
    }

    static int func(int n) {

        if(dp[n]!=null) {
            return dp[n];
        }

        if(n%6==0) {
            return dp[n]=(1+Math.min(func(n-1),Math.min(func(n/3), func(n/2))));
        } else if(n%3==0) {
            return dp[n]=(1+Math.min(func(n/3),func(n-1)));
        } else if(n%2==0) {
            return dp[n]=(1+Math.min(func(n/2),func(n-1)));
        } else {
            return dp[n]=(1+func(n-1));
        }
    }
}
