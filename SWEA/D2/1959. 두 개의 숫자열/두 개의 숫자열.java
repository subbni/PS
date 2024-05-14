import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[N];
            int[] arr2 = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int[] biggerArr = new int[Math.max(N, M)];
            int[] smallerArr = new int[Math.min(N, M)];
            if(biggerArr.length == N) {
                biggerArr = arr1;
                smallerArr = arr2;
            } else {
                biggerArr = arr2;
                smallerArr = arr1;
            }

            int max = Integer.MIN_VALUE;
            for(int i=0; i<=(biggerArr.length-smallerArr.length); i++) {
                int sum = 0;
                for(int j=0; j<smallerArr.length; j++) {
                    sum += (biggerArr[i+j]*smallerArr[j]);
                }
                if(sum > max) max = sum;
            }
            sb.append("#"+t+" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}
