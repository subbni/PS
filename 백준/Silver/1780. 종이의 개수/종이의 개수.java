import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] paper;
  static int[] countArr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    countArr = new int[3];
    paper = new int[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    divide(0, 0, N);

    for(int i=0; i<3; i++) {
      System.out.println(countArr[i]);
    }
    br.close();
  }

  public static void divide(int startX, int startY, int size) {
    if(checkAllSame(startX, startY, size)) {
      countArr[paper[startX][startY]+1]++;
      return;
    } 

    int newSize = size/3;
    for(int i=0; i<3; i++) {
      for(int j=0; j<3; j++) {
        divide(startX+i*newSize, startY+j*newSize, newSize);
      }
    }
  }

  public static boolean checkAllSame(int x, int y, int size) {
    int first = paper[x][y];
    for(int i=x; i<x+size; i++) {
      for(int j=y; j<y+size; j++) {
        if(paper[i][j]!=first) {
          return false;
        }
      }
    }
    return true;
  }
}
