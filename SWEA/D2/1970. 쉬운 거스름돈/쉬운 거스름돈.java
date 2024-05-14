import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int[] coinCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int money = Integer.parseInt(br.readLine());
            coinCnt = new int[coin.length];
            calculate(money);
            sb.append("#"+t).append('\n');
            for(int cnt: coinCnt) {
                sb.append(cnt).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void calculate(int money) {
        int remain = money;
        for(int i=0; i<coin.length; i++) {
            if(remain/coin[i] > 0) {
                coinCnt[i] = remain/coin[i];
                remain = remain%coin[i];
            }
            if(remain == 0) break;
        }
    }
}
