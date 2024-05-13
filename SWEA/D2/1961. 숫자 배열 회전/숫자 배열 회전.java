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
            int[][] matrix = new int[N][N];
            StringTokenizer st;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#"+t).append('\n');
            
            for(int i=0; i<N; i++) { // 각 행에 대해서
                for(int j=0; j<N; j++) {
                    sb.append(matrix[N-1-j][i]);
                }
                sb.append(' ');
                for(int j=0; j<N; j++) {
                    sb.append(matrix[N-1-i][N-1-j]);
                }
                sb.append(' ');
                for(int j=0; j<N; j++) {
                    sb.append(matrix[j][N-1-i]);
                }
                sb.append(' ');
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
