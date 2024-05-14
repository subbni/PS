import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int check = 0;
            int cnt = 1;
            for(; check < Math.pow(2, 10)-1;cnt++) {
                int number = N * cnt;
                while(number>0) {
                    check = check | (1<<(number%10));
                    number /= 10;
                }
            }
            sb.append("#"+t+" ").append((cnt-1)*N).append('\n');
        }
        System.out.print(sb);
    }
}
