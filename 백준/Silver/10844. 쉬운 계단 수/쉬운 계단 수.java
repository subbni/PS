import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[10][N+1]; // 0~9로 시작하는 길이가 N인 계단수의 개수
        for(int i=0; i<=9; i++) {
            memo[i][1] = 1;
        }
        long sum = 0;
        for(int i=1; i<=9; i++) {
            dp(i,N);
            sum += memo[i][N];
        }
        System.out.println(sum%1000000000);
    }

    static void dp(int num, int len) {
        if(len==0 || memo[num][len]!=0) return;
        if(num > 0) {
            dp(num-1,len-1);
            memo[num][len] = (memo[num][len]+memo[num-1][len-1])%1000000000;
        } 
        if(num < 9) {
            dp(num+1,len-1);
            memo[num][len] = (memo[num][len]+memo[num+1][len-1])%1000000000;
        }
    }
}
