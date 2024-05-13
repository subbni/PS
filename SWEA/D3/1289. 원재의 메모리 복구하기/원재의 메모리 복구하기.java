import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String[] arr = br.readLine().split("");
            String[] tmp = {"0","1"};
            int cnt = 0;
            int idx = 0;
            for(int i=0; i<arr.length; i++) {
                if(!arr[i].equals(tmp[idx])) {
                    cnt++;
                    idx = (idx+1)%2;
                }
            }
            sb.append("#"+t+" ").append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
