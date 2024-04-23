import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] inDp = new int[N];
        int[] deDp = new int[N];
        int ans = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=N-1; i>=0; i--) {
            for(int j=i+1; j<N; j++) {
                if(arr[j] > arr[i]) {
                    // LIS
                    inDp[i] = Math.max(inDp[i],inDp[j]);
                } else {
                    deDp[i] = Math.max(deDp[i],deDp[j]);
                }
            }

            inDp[i]++;
            deDp[i]++;
            ans = Math.max(ans, inDp[i]+deDp[i]-1);
        }

        System.out.println(ans);
    }
}
