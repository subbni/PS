import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N = 100;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int t=1; t<=T; t++) {
            br.readLine();
            arr = new int[N][N];
            StringTokenizer st;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Math.max(checkRowAndCol(),checkDiagonalLine());
            sb.append("#"+t+" ").append(max).append('\n');
        }
        System.out.print(sb);
    }

    static int checkRowAndCol() {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) { // 행
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum += arr[i][j];
            }
            if(sum > max) max = sum;
        }
        for(int i=0; i<N; i++) { // 열
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum += arr[j][i];
            }
            if(sum > max) max = sum;
        }
        return max;
    }

    static int checkDiagonalLine() {
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0; i<N; i++) { // 열
            leftSum += arr[i][i];
            rightSum += arr[i][N-1-i];
        }
        return Math.max(leftSum,rightSum);
    }
}
