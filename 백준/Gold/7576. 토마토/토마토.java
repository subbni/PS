import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {0,0,-1,1};
  static int[] dy = {1,-1,0,0};
  static int N,M;
  static int[][] tomato;
  static int leftTomato;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken()); // 가로
    N = Integer.parseInt(st.nextToken()); // 세로
    tomato = new int[N][M];
    Queue<int[][]> queue = new ArrayDeque<>();
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());
        if(tomato[i][j]==0) {
          leftTomato++;
        } else if(tomato[i][j]==1) {
          queue.add(new int[][] {{i,j,0}});
        }
      }
    }
    int answer = leftTomato == 0 ? 0 : getMinimumDays(queue);
    System.out.println(answer);
  }

  public static int getMinimumDays(Queue<int[][]> queue) {
    while(!queue.isEmpty()) {
      int[][] cur = queue.poll();
      int x = cur[0][0];
      int y = cur[0][1];
      int days = cur[0][2];
      for(int i=0; i<4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];
        if(nx>=N || ny>=M || nx<0 || ny<0 || tomato[nx][ny]!=0) continue;
        if(--leftTomato == 0) {
          return days+1;
        } else {
          tomato[nx][ny] = 1;
          queue.add(new int[][] {{nx,ny,days+1}});
        }
      }
    }
    return -1;
  }

}
