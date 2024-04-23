import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while((line = br.readLine()) != null) {
                int N = Integer.parseInt(line.trim());
                int[] arr = new int[N];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0; i<N; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                memo = new int[N+1];
                int len = 0, idx = 0;
                for(int i=0; i<N; i++) {
                    if (arr[i] > memo[len]) {
                        len++;
                        memo[len] = arr[i];
                    } else {
                        idx = binarySearch(0, len, arr[i]);
                        memo[idx] = arr[i];
                    }
                }
                sb.append(len+"\n");
            }
        } catch(Exception e) {

        } finally {
            System.out.println(sb.toString());
        }

    }
    
    static int binarySearch(int left, int right, int key) {
        int mid;
        while(left < right) {
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
