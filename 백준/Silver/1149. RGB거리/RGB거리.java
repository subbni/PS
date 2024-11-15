import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[][] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		cost= new int[N][N];
		d = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		d[0][0] = cost[0][0];
		d[0][1] = cost[0][1];
		d[0][2] = cost[0][2];
		
		int min = Math.min(dp(N-1,0),Math.min(dp(N-1,1),dp(N-1,2)));
		System.out.print(min);
	}
	
	public static int dp(int n, int color) {
		if(n >= N) return Integer.MAX_VALUE;
		if(d[n][color]!=0) return d[n][color];
		return d[n][color] = Math.min(dp(n-1, (color+1)%3), dp(n-1, (color+2)%3))+cost[n][color];
	}
}
