import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        int cnt = 0;
        int sum = 1;
        int s = 0, e = 0;
        while(s<n) {
            if(sum == n) {
                cnt++;
                sum -= arr[s];
                s++;
            } else if(sum > n) {
                sum -= arr[s];
                s++;
            } else {
                if(e<n-1) {
                    e++;
                    sum += arr[e];
                } else {
                    sum -= arr[s];
                    s++;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
