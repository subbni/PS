import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] d;
	static int[] next;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		d = new int[x+1];
		d[1] = 0;
		next = new int[x+1];
		next[1] = 0;
		int min = dp(x);
		StringBuilder sb = new StringBuilder();
		sb.append(min).append("\n");
		int nextNum = x;
		while(nextNum >= 1) {
			sb.append(nextNum).append(' ');
			nextNum = next[nextNum];
		}
		System.out.println(sb);
		br.close();
	}
	
	public static int dp(int x) {
		if(d[x] > 0 || x<=1) {
			return d[x];
		}
		
		int min = Integer.MAX_VALUE;
		if(x%3 == 0) {
			if(min > dp(x/3)+1) {
				min = d[x/3]+1;
				next[x] = x/3;
			}
		}
		if(x%2 == 0) {
			if(min > dp(x/2)+1) {
				min = d[x/2]+1;
				next[x] = x/2;
			}
		}
		if(min > dp(x-1)+1) {
			min = d[x-1]+1;
			next[x] = x-1;
		}
		
		return d[x] = min;
	} 
}
