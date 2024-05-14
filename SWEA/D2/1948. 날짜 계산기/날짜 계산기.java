import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] lastDate = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstMonth = Integer.parseInt(st.nextToken());
            int firstDate = Integer.parseInt(st.nextToken());
            int secondMonth = Integer.parseInt(st.nextToken());
            int secondDate = Integer.parseInt(st.nextToken());
            int answer = calculateDate(firstMonth, firstDate, secondMonth, secondDate);
            sb.append("#"+t+" ").append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static int calculateDate(int firstMonth, int firstDate, int secondMonth, int secondDate) {
        int result = 0;
        if(secondMonth - firstMonth > 1) {
            for(int i=firstMonth+1; i<=secondMonth-1; i++) {
                result += lastDate[i];
            }
        } 
        result += (lastDate[firstMonth]-firstDate)+1;
        if(firstMonth != secondMonth) {
            result += secondDate;
        }
        return result;
    }
}
