import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String word = br.readLine();
            int s = 0;
            int e = word.length()-1;
            while(s<=e) {
                if(word.charAt(s++) != word.charAt(e--)) {
                    break;
                }
            }
            sb.append("#"+t+" ");
            if(s>e) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.print(sb);
    }
}
