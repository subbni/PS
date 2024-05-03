import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] ans;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N];
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i=0; i<N; i++) {
            ans[depth] = i;
            if(checkPosition(depth)) {
                dfs(depth+1);
            }
        }
    }

    public static boolean checkPosition(int depth) {
        for(int i=0; i<depth; i++) {
            // 같은 행이 위치
            if(ans[depth] == ans[i]) {
                return false;
            }
            // 대각선 상 위치
            if(Math.abs(i-depth) == Math.abs(ans[i]-ans[depth])) {
                return false;
            }
        }
        return true;
    }

}
