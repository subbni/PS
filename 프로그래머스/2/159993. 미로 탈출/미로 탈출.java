import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static class Data {
    int i;
    int j;
    int sum;
    Data(int i, int j, int sum) {
      this.i = i;
      this.j = j;
      this.sum = sum;
    }
  }

  static int[] dx = {0,1, 0,-1};
  static int[] dy = {1,0,-1,0};
  static char[][] map;
  static boolean[][] visited;

  public int solution(String[] maps) {
    map = new char[maps.length][maps[0].length()];
    visited = new boolean[maps.length][maps[0].length()];
    int startI = 0; int startJ = 0;
    int leverI = 0; int leverJ = 0;
    int endI = 0; int endJ = 0;
    for(int i=0; i<maps.length; i++) {
      String row = maps[i];
      for(int j=0; j<maps[i].length(); j++) {
        map[i][j] = row.charAt(j);
        if(map[i][j] == 'S') {
          startI = i; startJ = j;
        } else if(map[i][j] == 'L') {
          leverI = i; leverJ = j;
        } else if(map[i][j] == 'E') {
          endI = i; endJ = j;
        }
      }
    }

    int startToLever = bfs(startI, startJ, leverI, leverJ);
    visited = new boolean[maps.length][maps[0].length()];
    int leverToEnd = bfs(leverI,leverJ,endI,endJ);
    
    int answer = 0;
    if(startToLever == -1 || leverToEnd == -1) {
      answer = -1;
    } else {
      answer = startToLever + leverToEnd;
    }
    return answer;
  }

  static int bfs(int startI, int startJ, int endI, int endJ) {
    Queue<Data> q = new ArrayDeque<>();
    q.add(new Data(startI, startJ, 0));
    visited[startI][startJ] = true;
    while(!q.isEmpty()) {
      Data cur = q.poll();
      if(cur.i == endI && cur.j == endJ) return cur.sum;

      for(int i=0; i<4; i++) {
        int nx = cur.i + dx[i];
        int ny = cur.j + dy[i];
        if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length) continue;
        if(map[nx][ny] == 'X' || visited[nx][ny]) continue;
        q.add(new Data(nx, ny, cur.sum+1));
        visited[nx][ny] = true;
      }
    }
    return -1;
  }
}