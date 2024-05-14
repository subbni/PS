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
            // P, Q, R, S, W
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int Afee = P * W;
            int Bfee = Q;
            if(R < W) {
                Bfee += (W-R)*S;
            }
            sb.append("#"+t+" ").append(Afee<Bfee?Afee:Bfee).append('\n');
        }
        System.out.print(sb);
	}
}