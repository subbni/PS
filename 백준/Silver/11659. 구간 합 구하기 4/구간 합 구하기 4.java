import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] num = new int[N+1];
		int[] sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+num[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ans = sum[end]-sum[start-1];
			sb.append(ans).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
