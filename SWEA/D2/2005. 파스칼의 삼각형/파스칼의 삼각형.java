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
            int[][] arr = new int[N][N];
            arr[0][0] = 1;
            for(int i=1; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] += arr[i-1][j];
                    if(j-1>=0) arr[i][j] += arr[i-1][j-1];
                }
            }
            sb.append("#"+t).append('\n');
            for(int i=0; i<N; i++) {
                int j = 0;
                while(j<N && arr[i][j]!=0) {
                    sb.append(arr[i][j]+" ");
                    j++;
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }   
}
