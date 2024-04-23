import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); // 사건의 개수
        int k = Integer.parseInt(st.nextToken()); // 알고 있는 사건의 전후 관계 개수
        int[][] matrix = new int[n+1][n+1];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            matrix[before][after] = -1;
            matrix[after][before] = 1;
        }

        for(int m=1; m<=n; m++) {
            for(int i=1; i<=n; i++) {
                if(matrix[i][m]==0) continue;
                for(int j=1; j<=n; j++) {
                    if(matrix[m][j]==0) continue;
                    if(matrix[i][m]*matrix[m][j] == 1) { // 부호가 같으면
                        matrix[i][j] = matrix[m][j];
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine()); // 알고자 하는 사건 관계 수
        for(int i=0; i<s; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            sb.append(matrix[before][after]).append("\n");
        }

        System.out.println(sb);
    }
}
