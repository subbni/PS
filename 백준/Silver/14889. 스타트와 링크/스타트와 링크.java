import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        selected = new boolean[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int depth) {
        if(depth == N/2) {
            // 능력치 합 계산
            int result = 0;
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    if(selected[i] && selected[j]) {
                        result += (matrix[i][j] + matrix[j][i]);
                    } else if(!selected[i] && !selected[j]){
                        result -= (matrix[i][j] + matrix[j][i]);
                    }
                } 
            }
            if(Math.abs(result) < min) min = Math.abs(result);
            return;
        }

        for(int i=idx; i<N; i++) {
            selected[i] = true;
            dfs(i+1, depth+1);
            selected[i] = false;
        }
    }
}
