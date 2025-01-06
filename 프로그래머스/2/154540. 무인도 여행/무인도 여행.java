import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static boolean[][] visited;
  static int[][] map;
  public int[] solution(String[] maps) {
    ArrayList<Integer> islands = new ArrayList<>();
    visited = new boolean[maps.length][maps[0].length()];
    map = new int[maps.length][maps[0].length()];
    for(int i=0; i<maps.length; i++) {
      for(int j=0; j<maps[0].length(); j++) {
        if(maps[i].charAt(j)=='X') {
          map[i][j] = -1;
        } else {
          // char to int
          map[i][j] = maps[i].charAt(j)-'0';
        }
      }
    }

    for(int i=0; i<map.length; i++) {
      for(int j=0; j<map[0].length; j++) {
        if(map[i][j]>0 && !visited[i][j]) {
          islands.add(getSumOfConnectedIslands(i, j, 0));
        }
      }
    }

    islands.sort(Comparator.naturalOrder());
    
    return islands.isEmpty()? new int[] {-1} : islands.stream().mapToInt(i->i).toArray();
  }

  static public int getSumOfConnectedIslands(int x, int y, int sum) {
    sum += map[x][y];
    visited[x][y] = true;
    for(int i=0; i<4; i++) {
      int nx = x+dx[i];
      int ny = y+dy[i];
      if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length || map[nx][ny]<0 || visited[nx][ny]) {
        continue;
      }
      sum = getSumOfConnectedIslands(nx, ny, sum);
    }
    return sum;
  }
}