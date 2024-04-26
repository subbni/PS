import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
            int result;
            if(X>L && X>U) {
                result = -1;
            } else if(X>L){
                result = 0;
            } else {
                result = L-X;
            }
            System.out.printf("#%d %d\n",test_case,result);
		}
	}
}
