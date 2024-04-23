import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1]; // 전봇대 i는 arr[i]와 연결되어있음

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[N+1];
        int len = 0;
        int idx = 0;
        for(int i=1; i<=N; i++) {
            if(arr[i] > memo[len]) {
                len++;
                memo[len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i]);
                memo[idx] = arr[i];
            }
        }
        System.out.println(N-len);
    }

    static int binarySearch(int left, int right, int key) {
        int mid;
        while(left<right) {
            mid = (left+right)/2;
            if(memo[mid] < key) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
