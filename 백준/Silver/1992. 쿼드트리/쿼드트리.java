import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static StringBuffer sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuffer();
    int N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for(int i=0; i<N; i++) {
      String[] str = br.readLine().split("");
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(str[j]);
      }
    }

    divide(0, 0, N);

    System.out.println(sb);
    br.close();
  }

  public static void divide(int x,int y,int size) {    
    if(checkIfAllSame(x, y, size)) {
      sb.append(map[x][y]);
      return;
    }
    sb.append("(");
    int newSize = size/2;
    divide(x, y, newSize);
    divide(x, y+newSize, newSize);
    divide(x+newSize, y, newSize);
    divide(x+newSize, y+newSize, newSize);
    sb.append(")");
  }

  public static boolean checkIfAllSame(int x, int y, int size) {
    int number = map[x][y];
    for(int i=0; i<size; i++) {
      for(int j=0; j<size; j++) {
        if(map[x+i][y+j] != number) {
          return false;
        }
      }
    }
    return true;
  }
}
