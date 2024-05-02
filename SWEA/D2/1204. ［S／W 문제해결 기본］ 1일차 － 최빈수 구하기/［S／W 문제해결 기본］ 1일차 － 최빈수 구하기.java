import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution
{
	    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T= Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] score = new int[101];
            while(st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                score[cur]++;
            }
            int maxIdx = 0;
            for(int i=1; i<=100; i++) {
                if(score[maxIdx] <= score[i]) {
                    maxIdx = i;
                }
            }
            bw.write("#"+test_case+" "+maxIdx);
            bw.newLine();
		}
        br.close();
        bw.flush();
        bw.close();
    }
}