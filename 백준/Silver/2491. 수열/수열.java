import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 1;
        int curMax = 0, curLen = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] >= curMax) {
                curLen++;
                curMax = arr[i];
                if(curLen > maxLen) maxLen = curLen;
            } else {
                if(curLen > maxLen) maxLen = curLen;
                curLen = 1;
                curMax = arr[i];
            }
        }

        int curMin = Integer.MAX_VALUE;
        curLen = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= curMin) {
                curLen++;
                curMin = arr[i];
                if(curLen > maxLen) maxLen = curLen;
            } else {
                if(curLen > maxLen) maxLen = curLen;
                curLen = 1;
                curMin = arr[i];
            }
        }
        System.out.println(maxLen);
    }
}
