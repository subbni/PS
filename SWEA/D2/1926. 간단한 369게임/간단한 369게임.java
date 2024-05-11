import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) {
            int cnt = 0;
            int tmp = i;
            int divisor = 1000;
            while(divisor > 0) {
                if(divisor < tmp) {
                    int mok = tmp / divisor;
                    if(mok == 3 || mok == 6 || mok == 9) {
                        cnt++;
                    }
                    tmp -= (divisor*mok);
                    
                }
                divisor /= 10;
            }
            if(cnt > 0) {
                while(cnt-- > 0) {
                    sb.append("-");
                }
            } else {
                sb.append(i);
            }
            sb.append(' ');
        }
        System.out.println(sb);
    }
}
