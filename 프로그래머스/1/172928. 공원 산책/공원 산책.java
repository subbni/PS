class Solution {
    public int[] solution(String[] park, String[] routes) {
    int[] answer = new int[2];
    boolean[][] map = new boolean[park.length][3]; 
    int curX = 0; int curY = 0;
    for(int i=0; i<park.length; i++) {
        char[] rowArr = park[i].toCharArray();
        for(int j=0; j<3; j++) {
            switch(rowArr[j]) {
                case 'S'-> {
                    map[i][j] = true;
                    curX = i; curY = j;
                }
                case 'O' -> map[i][j] = true;
                case 'X' -> map[i][j] = false;
            }
        }
    }
    
    for(String route: routes) {
        String[] command = route.split(" ");
        boolean possibleCommand = true;        
        int nx = curX;
        int ny = curY;
        for(int i=1; i<=Integer.parseInt(command[1]); i++) {
          switch (command[0].charAt(0)) {
            case 'N' -> nx--;
            case 'E' -> ny++;
            case 'S' -> nx++;
            case 'W' -> ny--;
          }
          if(nx<0 || nx>=park.length || ny<0 || ny>=3 || !map[nx][ny]) {
            possibleCommand = false;
            break;
          } 
        }
        if(possibleCommand) {
          curX = nx;
          curY = ny;
        }
      }
    return new int[] {curX, curY};
  }
}