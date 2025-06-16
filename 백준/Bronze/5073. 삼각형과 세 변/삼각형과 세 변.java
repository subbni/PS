import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Equilateral : 세 변의 길이가 같음
// Isosceles : 두 변의 길이가 같음
// Scalene : 세 변의 길이가 모두 다름
// Invalid : 가장 긴 변의 길이가 다른 두 변의 길이의 합보다 길거나 같다

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while(true) {
      st = new StringTokenizer(br.readLine());
      int[] edges = new int[3];
      for (int i=0; i<3; i++) {
        edges[i] = Integer.parseInt(st.nextToken());
      }

      if (edges[0] == 0 && edges[0] == 0 && edges[0] == 0) {
        break;
      }

      Arrays.sort(edges);

      if (edges[0] + edges[1] > edges[2]) {
        if (edges[0] == edges[1] && edges[1] == edges[2] && edges[0] == edges[2]) {
          sb.append("Equilateral\n");
        } else if (edges[0] != edges[1] && edges[1] != edges[2] && edges[0] != edges[2]) {
          sb.append("Scalene\n");
        } else {
          sb.append("Isosceles\n");
        }
      } else {
        sb.append("Invalid\n");
      }
    }

    System.out.print(sb);
  }
}