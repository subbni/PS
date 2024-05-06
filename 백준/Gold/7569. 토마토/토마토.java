import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static List<int[]> tomato = new ArrayList<>();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        for(int k=0; k<H; k++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if(box[k][i][j] == 1) tomato.add(new int[] {k,i,j});
                    if(box[k][i][j] == 0) cnt++;
                }
            }
        }

        processRipening(0,0);
        int result = -1;
        if(cnt == 0) {
            int max = 0;
            for(int k=0; k<H; k++) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        if(max < box[k][i][j]) max = box[k][i][j];
                    }
                }
            }
            result = max-1;
        } 
        System.out.println(result);
    }

    public static void processRipening(int idx, int day) {
        for(int t=idx; t<tomato.size(); t++) {
            int[] pos = tomato.get(t);
            for(int i=0; i<6; i++) {
                int nz = pos[0]+dz[i];
                int nx = pos[1]+dx[i];
                int ny = pos[2]+dy[i];
                
                if(nz<0 || nz>=H || nx<0 || nx>=N || ny<0 || ny>=M) {
                    continue;
                }

                if(box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = box[pos[0]][pos[1]][pos[2]]+1;
                    tomato.add(new int[] {nz,nx,ny});
                    cnt--;
                }
            }
        }

    }
}
