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
            StringTokenizer st;
            int distance = 0;
            int pace = 0;
            while(N-->0) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("1")) {
                    pace += Integer.parseInt(st.nextToken());
                } else if(command.equals("2")) {
                    pace -= Integer.parseInt(st.nextToken());
                    if(pace<0) pace = 0;
                }
                distance += pace;
            }
            sb.append("#"+t+" ").append(distance).append('\n');
        }
        System.out.print(sb);
    }   
}
