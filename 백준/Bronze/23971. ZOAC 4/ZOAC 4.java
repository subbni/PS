import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// H(행), W(열), N(세로로 띄워야 하는 칸), M(가로로 띄워야 하는 칸)
// 문제 : 세로로 N 또는 가로 M만큼 띄워서 앉을 수 있을 때, 최대 몇 명 수용 가능?

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int rows = Integer.parseInt(st.nextToken()); 
    int cols = Integer.parseInt(st.nextToken()); 
    int minHeightSpace = Integer.parseInt(st.nextToken()); 
    int minWidthSpace = Integer.parseInt(st.nextToken()); 

    int answer = 0;
    int availableRowCnt = rows/(minHeightSpace+1);
    if (rows%(minHeightSpace+1) != 0) availableRowCnt ++; 
    
    int availableColCnt = cols/(minWidthSpace+1);
    if (cols%(minWidthSpace+1) != 0) availableColCnt ++;

    answer = availableRowCnt * availableColCnt;
    System.out.println(answer);
  }
}
