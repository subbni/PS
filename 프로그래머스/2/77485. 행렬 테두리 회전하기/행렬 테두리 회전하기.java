class Solution {
    static int[][] map;
  public int[] solution(int rows, int columns, int[][] queries) {
    map = new int[rows][columns];
    int[] answer = new int[queries.length];
    for(int i=0; i<rows; i++) {
      for(int j=0; j<columns; j++) {
        map[i][j] = i*columns+ j+1;
      }
    }

    for(int i=0; i<queries.length; i++) {
        answer[i] = processQuery(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
    }
    return answer;
  }

  public int processQuery(int x1, int y1, int x2, int y2) {
    int prev = map[x1][y1];
    int min = map[x1][y1];
    for(int y=y1+1; y<=y2; y++) {
      // 1. 이전 값을 현재 값으로 옮긴다.
      int temp = map[x1][y];
      map[x1][y] = prev;
      // 2. 원래 현재 값을 Prev로 저장한다.
      prev = temp;
      // 3. min 확인
      min = Math.min(min,prev);
    }
    for(int x=x1+1; x<=x2; x++) {
      int temp = map[x][y2];
      map[x][y2] = prev;
      prev = temp;
      min = Math.min(min,prev);
    }
    for(int y=y2-1; y>=y1; y--) {
      int temp = map[x2][y];
      map[x2][y] = prev;
      prev = temp;
      min = Math.min(min,prev);
    }
    for(int x=x2-1;x>=x1; x--) {
      int temp = map[x][y1];
      map[x][y1] = prev;
      prev = temp;
      min = Math.min(min,prev);
    }
    return min;
  }
}