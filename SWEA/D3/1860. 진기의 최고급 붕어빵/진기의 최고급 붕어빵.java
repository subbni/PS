import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 손님
            int M = Integer.parseInt(st.nextToken()); // 1회당 만드는 시간
            int K = Integer.parseInt(st.nextToken()); // 1회당 만드는 개수
            int[] customer = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                customer[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(customer);
            String result = "Possible";
            int stock = 0;
            for(int i=0; i<N; i++) {
                stock = (customer[i]/M)*K - i;
                if(stock < 1) {
                    result = "Impossible";
                    break;
                }
            }
            sb.append("#"+t+" ").append(result).append('\n');
        }
        System.out.print(sb);
    }
}
