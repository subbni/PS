import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아래 조건을 만족하는 길이가 M인 수열을 모두 구하라.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다. 
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        arr = new int[M];

        dfs(1,0);
        System.out.println(sb);
    }

    public static void dfs(int pos, int depth) {
        if(depth == M) {
            for(int val: arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=pos; i<=N; i++) {
            arr[depth] = i;
            dfs(i,depth+1);
        }
    }
}
