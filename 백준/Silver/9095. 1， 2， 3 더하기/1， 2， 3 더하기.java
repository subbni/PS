import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			memo = new int[n+1];
			memo[0] = 1;
			memo[1] = 1;
			if(n>1) {
				memo[2] = 2;
			}
			sb.append(dp(n)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static int dp(int n) {
		if(memo[n]>0) {
			return memo[n];
		}
		return memo[n] = dp(n-1) + dp(n-2) + dp(n-3); 
	}

}
