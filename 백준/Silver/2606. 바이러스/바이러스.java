import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();   // 총 컴퓨터의 수
        int K = in.nextInt();   // 연결쌍 수 
        matrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int k = 0; k < K; k++) {
            int i = in.nextInt();
            int j = in.nextInt();
            matrix[i][j] = 1;
            matrix[j][i] = 1;
        }
        System.out.println(dfs(1,0));
        in.close();
    }

    static int dfs(int v, int count) {
        visited[v] = true;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[v][i]==1 && !visited[i]) {
                count = 1+dfs(i,count);
            }
        }
        return count;
    }
}
