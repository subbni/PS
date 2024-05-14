import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int N = 16;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int t=1; t<=T; t++) {
            br.readLine();
            board = new int[N][N];
            visited = new boolean[N][N];
            int startX = 0;
            int startY = 0;
            for(int i=0; i<N; i++) {
                String[] line = br.readLine().split("");
                for(int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                    if(board[i][j]==2) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            int result = bfs(startX, startY);
            sb.append("#"+t+" ").append(result).append('\n');
        }
        System.out.print(sb);
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY});
        board[startX][startY] = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N || board[nx][ny]==1) continue;
                
                if(board[nx][ny] == 3) {
                    return 1;
                }

                board[nx][ny] = 1;
                queue.add(new int[] {nx,ny});
            }
        }
        return 0;
    }
}
