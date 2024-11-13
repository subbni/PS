import java.io.*;
import java.util.*;

public class Main {
  static int[][] map;
  static boolean[][] visited;
  static int N,M;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {1,-1,0,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];
    for(int i=0; i<N; i++) {
      char[] numbers = br.readLine().toCharArray();
      for(int j=0; j<M; j++) {
        map[i][j] = numbers[j]-'0';
      }
    }
    int answer = bfs();
    System.out.println(answer);
  }

  static public int bfs() {
    Queue<int[][]> queue = new ArrayDeque<>();
    queue.add(new int[][] {{0, 0, 1}});
    visited[0][0] = true;
    while(!queue.isEmpty()) {
      int[][] cur = queue.poll();
      int x = cur[0][0];
      int y = cur[0][1];
      int cnt = cur[0][2];
      if(x==N-1 && y==M-1) {
        return cnt;
      } 
      for(int i=0; i<4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];
        if(nx>=N || nx<0 || ny>=M || ny<0 || visited[nx][ny] || map[nx][ny]==0) continue;
        visited[nx][ny] = true;
        queue.add(new int[][] {{nx,ny,cnt+1}});
      }
    }
    return 0;
  }
}
