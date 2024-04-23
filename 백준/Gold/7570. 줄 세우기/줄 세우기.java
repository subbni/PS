import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(st.nextToken())] = i;
        }

        // LIS를 구한다. 단,  ** LIS의 원소들은 연속하여야 한다. **
        int max = 1;
        int cnt = 0;
        for(int i=1; i<N; i++) {
            if(arr[i] > arr[i-1]) {
                if(++cnt > max) {
                    max = cnt;
                }
            } else {
                cnt = 1;
            }
        }
        System.out.println(N-max);
    }
}
