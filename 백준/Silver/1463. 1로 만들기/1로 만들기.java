import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		memo = new int[x+1];
		memo[1] = 0;
		System.out.println(dp(x));
		br.close();
	}
	
	public static int dp(int num) {
		if(memo[num]>0 || num<=1) {
			return memo[num];
		}
		
		int min = Integer.MAX_VALUE;
		if(num%3 == 0) {
			min = Math.min(min, dp(num/3)+1);
		}
		if(num%2 == 0) {
			min = Math.min(min, dp(num/2)+1);
		}
		min = Math.min(min, dp(num-1)+1);
		return memo[num] = min; 
	}

}
