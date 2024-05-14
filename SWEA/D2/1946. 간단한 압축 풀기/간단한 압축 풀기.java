import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            StringTokenizer st;
            sb.append("#"+t).append('\n');
            while(N-->0) {
                st = new StringTokenizer(br.readLine());
                String alphabet = st.nextToken();
                int times = Integer.parseInt(st.nextToken());
                for(int i=0; i<times; i++) {
                    sb.append(alphabet);
                    if(++cnt%10 == 0) sb.append('\n');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
