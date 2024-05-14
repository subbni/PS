import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i]>max) {
                    max = arr[i];
                }
                if(arr[i]<min) {
                    min = arr[i];
                }
            }
            Double sum = 0.0;
            for(int i=0; i<10; i++) {
                if(arr[i]==max || arr[i]==min) continue;
                sum += arr[i];
            }
            
            sb.append("#"+t+" ").append(Math.round(sum/8)).append('\n');
        }
        System.out.print(sb);
    }
}

