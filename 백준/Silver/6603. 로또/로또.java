import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            arr = new int[K];
            ans = new int[6];
            for(int i=0; i<K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append('\n');
        }

        bw.write(new String(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int depth) {
        if(depth == 6) {
            for(int val: ans) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=idx; i<K; i++) {
            ans[depth] = arr[i];
            dfs(i+1,depth+1);
        }
    }
}
    
