import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if(S == 0) {
            cnt -= 1;
        } // sum이 0으로 초기화 되어 있기 때문에, dfs()시 아무것도 택하지 않는 경우 cnt++; 된다.
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == S) {
                cnt++;
            }
            return;
        }
        dfs(depth+1,sum+arr[depth]);
        dfs(depth+1, sum);
    }
}
