import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> chickenPlaces = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();  
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    houses.add(new int[] {i,j});
                } else if(map[i][j]==2) {
                    chickenPlaces.add(new int[] {i,j});
                }
            }
        }

        chooseChickenPlace(0,0);
        System.out.println(min);
    }

    public static void chooseChickenPlace(int idx, int depth) {
        if(depth == M) {
            int sum = getSumOfChickenDistance();
            if(sum < min) {
                min = sum;
            }
            return;
        }

        for(int i=idx; i<chickenPlaces.size(); i++) {
            int[] cur = chickenPlaces.get(i);
            if(map[cur[0]][cur[1]]>1) {
                map[cur[0]][cur[1]] = -1; // 현재 선택한 치킨 집은 -1로 마킹
                chooseChickenPlace(i+1, depth+1);
                map[cur[0]][cur[1]] = 2;
            }
        }
    }

    // 도시의 치킨 거리 값을 반환
    public static int getSumOfChickenDistance() {
        int sum = 0;
        for(int i=0; i<houses.size(); i++) {
            int[] cur = houses.get(i);
            sum += getChickenDistance(cur);
        }
        return sum;
    }

    // 해당 좌표의 집에서 가장 가까운 치킨집을 찾아 치킨 거리를 반환
    public static int getChickenDistance(int[] hPos) {
        int chickenDistance = Integer.MAX_VALUE;
        for(int i=0; i<chickenPlaces.size(); i++) {
            int[] cPlace = chickenPlaces.get(i);
            if(map[cPlace[0]][cPlace[1]]<0) {
                if(Math.abs(hPos[0]-cPlace[0])+Math.abs(hPos[1]-cPlace[1]) < chickenDistance) {
                    chickenDistance = Math.abs(hPos[0]-cPlace[0])+Math.abs(hPos[1]-cPlace[1]);
                }
            }       
        }
        return chickenDistance;
    }
}
