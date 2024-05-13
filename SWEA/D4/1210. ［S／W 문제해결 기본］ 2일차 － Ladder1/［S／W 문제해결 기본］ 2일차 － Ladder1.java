import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0,0,-1}; // 좌,우,상
    static int[] dy = {-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        int destRow = 0;
        int destCol = 0;
        for(int t=1; t<=T; t++) {
            br.readLine();
            board = new int[100][100];
            visited = new boolean[100][100];
            StringTokenizer st;
            for(int i=0; i<100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j]==2) {
                        destRow = i;
                        destCol = j;
                    }
                }
            }
            
            sb.append("#"+t+" ").append(dfs(destRow,destCol)).append('\n');
        }
        System.out.print(sb);
    }

    static int dfs(int row, int col) {
        if(row == 0) {
            return col;
        }
        int result = 0;
        for(int i=0; i<3; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(nx<0 || nx>=100 || ny<0 || ny>=100 || board[nx][ny]==0)  continue;
            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                result = dfs(nx,ny);
                break;
            }
        }
        return result;
    }
}
