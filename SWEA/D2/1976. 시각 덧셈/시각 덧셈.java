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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour1 = Integer.parseInt(st.nextToken());
            int min1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int min2 = Integer.parseInt(st.nextToken());
            
            int ansHour  = hour1 + hour2;
            ansHour += (min1+min2)/60;
            ansHour = (ansHour%12);
            if(ansHour == 0) ansHour = 12;
            int ansMin = (min1+min2)%60;
            sb.append("#"+t+" ").append(ansHour+" ").append(ansMin+"\n");
        }
        System.out.print(sb);
	}
}