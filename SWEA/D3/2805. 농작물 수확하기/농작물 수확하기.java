import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] ground = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] input = br.readLine().split("");
                for(int j=0; j<N; j++) {
                    ground[i][j] = Integer.parseInt(input[j]);
                }
            }
            int profit = 0;
            for(int i=0; i<=N/2; i++) {
                for(int j=0; j<=i; j++) {
                    profit += ground[i][N/2+j];
                    if((N/2-j)!=(N/2+j)) {
                        profit += ground[i][N/2-j];
                    }
                }
            }
            for(int i=N/2+1; i<N; i++) {
                for(int j=(N-1-i); j>=0; j--) {
                    profit += ground[i][N/2+j];
                    if((N/2-j)!=(N/2+j)) {
                        profit += ground[i][N/2-j];
                    }
                }
            }
            sb.append("#"+t+" ").append(profit).append('\n');
        }
        System.out.println(sb);
    }
}
