import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Double[] score = new Double[N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                double average = Double.parseDouble(st.nextToken()) * 0.35;
                average += Double.parseDouble(st.nextToken()) * 0.45;
                average += Double.parseDouble(st.nextToken()) * 0.20;
                score[i] = average;
            }
            List<Double> scoreList = new ArrayList<Double>(Arrays.asList(score));
            Collections.sort(scoreList,Comparator.reverseOrder());
            int gradeIdx = scoreList.indexOf(score[K-1])/(N/10);
            sb.append("#"+t+" ").append(grade[gradeIdx]).append('\n');
        }
        System.out.print(sb);
    }
}
