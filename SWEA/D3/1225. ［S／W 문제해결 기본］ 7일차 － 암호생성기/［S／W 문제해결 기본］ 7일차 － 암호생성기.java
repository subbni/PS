import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int t=1; t<=T; t++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] num = new int[8];
            for(int i=0; i<8; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            int idx = 0;
            boolean finished = false;
            while(true) {
                for(int i=0; i<5; i++) {
                    if(num[(idx+i)%8]-(i+1) <= 0) {
                        num[(idx+i)%8] = 0;
                        idx = (idx+i+1)%8;
                        finished = true;
                        break;
                    }
                    num[(idx+i)%8] -= (i+1);
                }
                if(finished) {
                    break;
                }
                idx = (idx+5)%8;
            }

            sb.append("#"+t+" ");
            for(int i=0; i<8; i++) {
                sb.append(num[(idx+i)%8]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
