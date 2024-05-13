import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N, L;
    static int[] score;
    static int[] calorie;
    static int scoreSum;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            score = new int[N];
            calorie = new int[N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            scoreSum = 0;
            max = Integer.MIN_VALUE;
            dfs(0,0);
            sb.append("#"+t+" ").append(max).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int calorieSum) {
        for(int i=idx; i<N; i++) 
        {
            if(calorieSum+calorie[i] <= L) {
                scoreSum += score[i];
                max = Math.max(scoreSum,max);
                dfs(i+1,calorieSum+calorie[i]);
                scoreSum -= score[i];
            }
        }
    }
}
