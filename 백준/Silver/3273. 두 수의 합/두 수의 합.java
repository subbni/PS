import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int cnt = 0;
        for(int s=0; s<n; s++) {
            for(int e=s+1; e<n; e++) {
                if(arr[s]+arr[e] == x) {
                    cnt++;
                }else if(arr[s]+arr[e] > x) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
