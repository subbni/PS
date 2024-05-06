import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<int[]> blank = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) blank.add(new int[] {i,j});
            }
        }

        System.out.println(getCntOfMaxSafeArea());
    }

    static int getCntOfMaxSafeArea() {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<blank.size(); i++) {
            int[] one = blank.get(i);
            map[one[0]][one[1]] = 1;
            for(int j=i+1; j<blank.size(); j++) {
                int[] two = blank.get(j);
                map[two[0]][two[1]] = 1;
                for(int k=j+1; k<blank.size(); k++) {
                    int[] three = blank.get(k);
                    map[three[0]][three[1]] = 1;
                    visited = new boolean[N][M];
                    // 바이러스 퍼트리기
                    int sum = getCntOfInfectedArea();
                    if(min > sum) min = sum;
                    map[three[0]][three[1]] = 0;
                }
                map[two[0]][two[1]] = 0;
            }
            map[one[0]][one[1]] = 0;
        }
        return blank.size()-min-3; // 원래 빈 칸 - 감염된 칸 - 새로 세운 벽
    }

    static int getCntOfInfectedArea() {
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==2 && !visited[i][j]) {
                    visited[i][j] = true;
                    sum += processInfecting(i, j);
                }
            }
        }
        return sum;
    }

    static int processInfecting(int row, int col) {
        int cnt = 0;
        for(int i=0; i<4; i++) {
            int nx = row+dx[i];
            int ny = col+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

            if(map[nx][ny]==0 && !visited[nx][ny]) {
                cnt++;
                visited[nx][ny] = true;
                cnt += processInfecting(nx, ny);
            }
        }
        return cnt;
    }
}
