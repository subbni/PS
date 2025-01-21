import java.util.*;
class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[4][11][11];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        // up = 0 left = 1 down = 2 right = 3
        int answer = 0;
        int x=5, y=5;
        int nx,ny;
        for(char dir: dirs.toCharArray()) {
            int d=-1;
            if(dir=='U') {
                d=0;
            }else if(dir=='D') {
                d=2;
            }else if(dir=='L') {
                d=1;
            }else if(dir=='R') {
                d=3;
            }
                     
            nx = x+dx[d];
            ny = y+dy[d];
            
            if(nx<0 || nx>10 || ny<0 || ny>10) continue;
            
            if(!visited[(d+2)%4][nx][ny] && !visited[d][x][y]) {
                answer++;
            }
            visited[d][x][y]=true;
            visited[(d+2)%4][nx][ny] =true;
            
            x = nx;
            y = ny;
        }
        return answer;
    }
}