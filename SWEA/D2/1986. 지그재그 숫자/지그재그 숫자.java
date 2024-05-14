import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int number = Integer.parseInt(br.readLine());
            int result = 0;
            for(int i=1; i<=number; i++) {
                if(i%2==0) {
                    result -= i;
                } else {
                    result += i;
                }
            }
            sb.append("#"+t+" ").append(result).append('\n');
        }
        System.out.print(sb);
    }
}