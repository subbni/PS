import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int[][] arr = new int[N+1][M+1];
        int[][] preSum = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
               arr[i][j] = Integer.parseInt(st.nextToken());
               preSum[i][j] = preSum[i][j-1]+arr[i][j];
            }
        }
        int K = Integer.parseInt(br.readLine());
        
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i=row1; i<=row2; i++) {
                sum += (preSum[i][col2]-preSum[i][col1-1]);
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
