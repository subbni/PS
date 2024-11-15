import java.util.Scanner;

public class Main {
	static int[] step;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		step = new int[n];
		d = new int[n];
		for(int i=0; i<n; i++) {
			step[i] = sc.nextInt();
		}
		d[0] = step[0];
		System.out.println(dp(n-1));
		sc.close();
	}
	
	public static int dp(int n) {
		if(n<0) return 0;
		if(d[n]!=0) return d[n];
		if(n==2) return Math.max(step[0], step[1])+step[2];
		
		
		return d[n] = Math.max(dp(n-2), dp(n-3)+step[n-1])+step[n];
	}
}
