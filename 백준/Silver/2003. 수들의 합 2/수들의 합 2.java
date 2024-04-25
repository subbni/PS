import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s=0, e=0;
        int cnt = 0;
        int tmp = arr[0];
        while(s < N) {
            if(e < N-1) {
                if(tmp > M) {
                    tmp -= arr[s];
                    s++;
                } else {
                    if(tmp == M) cnt++;
                    e++;
                    tmp += arr[e];
                }
            } else {
                if(tmp == M) {
                    cnt++;
                }
                tmp -= arr[s];
                s++;
            }
        }
        System.out.println(cnt);
    }
}
