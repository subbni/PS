import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        memo = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i==N-1) {
                    memo[i][j] = arr[i][j];
                }
            }
        }
        dp(0,0);
        System.out.println(memo[0][0]);
    }

    static void dp(int row, int col) {
        if(row==N-1 || memo[row][col]!=0) return;
        dp(row+1,col);
        dp(row+1,col+1);
        memo[row][col] = arr[row][col] + Math.max(memo[row+1][col],memo[row+1][col+1]);
    }
}
