import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0; i+M<=N; i++) {
                for(int j=0; j+M<=N; j++) {
                    int sum = getSumOfFlies(i, j);
                    if(max < sum) max = sum;
                }
            }
            sb.append("#"+t+" ").append(max).append('\n');
        }
        System.out.print(sb);
    }

    public static int getSumOfFlies(int row, int col) {
        int sum = 0;
        for(int i=row; i<row+M; i++) { 
            for(int j=col; j<col+M; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
