import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, K;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            board = new int[N+1][N+1];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = checkRow() + checkCol();
            sb.append("#"+t+" ").append(result).append('\n');
        }
        System.out.print(sb);
    }

    static int checkRow() {
        int cnt = 0;
        for(int i=0; i<=N; i++) {
            int tmp = 0;
            for(int j=0; j<=N; j++) {
                if(board[i][j]==1) {
                    tmp ++;
                } else {
                    if(tmp == K) {
                        cnt ++;
                        tmp = 0;
                    } else {
                        tmp = 0;
                    }
                }
            }
        }
        return cnt;
    }

    static int checkCol() {
        int cnt = 0;
        for(int i=0; i<=N; i++) {
            int tmp = 0;
            for(int j=0; j<=N; j++) {
                if(board[j][i]==1) {
                    tmp ++;
                } else {
                    if(tmp == K) {
                        cnt ++;
                        tmp = 0;
                    } else {
                        tmp = 0;
                    }
                }
            }
        }
        return cnt;
    }
}
