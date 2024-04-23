import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static ArrayList<ArrayList<Path>> pathList; 
    static int N, M, W;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());
        while(TC-->0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점의 수
            M = Integer.parseInt(st.nextToken()); // 도로의 개수
            W = Integer.parseInt(st.nextToken()); // 웜홀의 개수
            dist = new int[N+1];
            pathList = new ArrayList<>(N+1);
            for(int i=0; i<=N; i++) {
                pathList.add(new ArrayList<Path>());
            }

            // 도로 정보 : 지점1, 지점2, 걸리는 시간
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken()); 
                int t = Integer.parseInt(st.nextToken()); 
                pathList.get(n1).add(new Path(n2,t));
                pathList.get(n2).add(new Path(n1,t));
            }

            // 웜홀 정보 : 시작지점, 도착지점, 줄어드는 시간(양수로 표현됨)
            for(int i=0; i<W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()); 
                int to = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken()); 
                pathList.get(from).add(new Path(to, -t));
            }

            boolean result = false;
            for(int i=1; i<=N; i++) {
                if(bellanFord(i)) {
                    result = true;
                    break;
                }
            }

            sb.append(result ? "YES\n":"NO\n");
        }
        System.out.println(sb);
    }

    public static boolean bellanFord(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0; // 시작점은 0으로 초기화
        boolean update = false;

        // (노드의 개수 -1)번 동안 최단거리 초기화 작업 
        for(int i=1; i<N; i++) { // 모든 노드에 대해서 (시작점)
            update = false;
            for(int j=1; j<=N; j++) { 
                for(Path path: pathList.get(j)) { 
                    if(dist[j]!=Integer.MAX_VALUE && dist[path.to] > dist[j]+path.weight) {
                        dist[path.to] = dist[j]+path.weight;
                        update = true;
                    }
                }
            }
            if(!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Path path : pathList.get(i)) {
                    if (dist[i] != Integer.MAX_VALUE && dist[path.to] > dist[i] + path.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Path {
        int to;
        int weight;
        public Path(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
