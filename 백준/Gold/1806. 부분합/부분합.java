import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주어진 수열의 길이
        int S = Integer.parseInt(st.nextToken()); // S의 합 이상이 되는 부분합 중 가장 짧은 것의 길이 구하기
        int[] arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(s<=N) {
            if(sum < S) {
                if(e<N) {
                    e++;
                    sum+=arr[e];
                } else {
                    sum-=arr[s];
                    s++;
                }               
            } else {
                if(e-s+1 < min) {
                    min = e-s+1;
                }      
                sum-=arr[s];
                s++;
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? 0 : min);
    }
}
