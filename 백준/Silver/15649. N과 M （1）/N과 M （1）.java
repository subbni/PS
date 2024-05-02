import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1부터 n까지 자연수 중에서
        M = Integer.parseInt(st.nextToken()); // 중복 없이 m개를 고른 수열을 출력
        visited = new boolean[N];
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int val: arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1; // 해당 깊이를 index로 하여 i+1 값 저장
                dfs(depth+1); // 다음 자식 노드 방문을 위해 depth 1 증가, 재귀호출
                // 방문 노드를 방문하지 않은 상태로 변경
                visited[i] = false;
            }
        }
    }
}
