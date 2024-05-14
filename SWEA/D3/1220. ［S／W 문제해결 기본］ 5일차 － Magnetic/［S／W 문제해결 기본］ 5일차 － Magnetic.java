import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=10; t++) {
            N = Integer.parseInt(br.readLine());
            table = new int[100][100];
            StringTokenizer st;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = checkCol();
            sb.append("#"+t+" ").append(result).append('\n');
        }
        System.out.print(sb);
    }

    static int checkCol() {
        int cnt = 0;
        for(int i=0; i<N; i++) { // 각 열에 대해서
            boolean checkN = false;
            for(int j=0; j<N; j++) { 
                if(table[j][i]==0) continue;
                if(table[j][i] == 1) { // N극 
                    checkN = true;
                } else { // S극
                    if(checkN == true) {
                        cnt++;
                        checkN = false;
                    }
                }
            }
        }
        return cnt;
    }
}
