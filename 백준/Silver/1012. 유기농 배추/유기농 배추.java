import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();   // 테스트 케이스의 개수
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int M = in.nextInt();   // 배추밭 가로 길이
            int N = in.nextInt();   // 배추밭 세로 길이
            int K = in.nextInt();   // 심겨진 배추의 수
            matrix = new int[N][M];
            visited = new boolean[N][M];
    
            for(int k = 0; k < K; k++) {
                int x = in.nextInt();
                int y = in.nextInt();
                matrix[y][x] = 1;
            }
            int count = 0;
            for(int i = 0; i < N ; i++) {
                for(int j = 0; j < M; j++) {
                    if(matrix[i][j]==1 && !visited[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        in.close();
    }

    static public void dfs(int i, int j) {
        visited[i][j] = true;
        for( int k = 0; k < 4 ; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length) {
                if(matrix[x][y]==1 && !visited[x][y]) {
                    dfs(x,y);
                }
            }
        }
    }
}
