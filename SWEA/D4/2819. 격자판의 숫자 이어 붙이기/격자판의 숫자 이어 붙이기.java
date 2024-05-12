import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상하좌우
    static int[] dy = {0, 1, 0, -1};
    static int[] arr = new int[7];
    static HashSet<String> hs;    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {

            board = new int[4][4];
            visited = new boolean[4][4];
            hs = new HashSet<>();
            StringTokenizer st;
            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    dfs(i,j,0);
                }
            }
            sb.append("#"+t+" ").append(hs.size()).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int row, int col, int depth) {
        if(depth == 7) {
            StringBuilder sb = new StringBuilder();
            for(int num : arr) {
                sb.append(num);
            }
            hs.add(new String(sb));
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;

            arr[depth] = board[nx][ny];
            dfs(nx,ny,depth+1);
        }
    }
}
