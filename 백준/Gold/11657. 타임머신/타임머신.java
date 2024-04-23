import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] dist;
    static ArrayList<ArrayList<Edge>> edgeList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
        dist = new long[N+1];
        edgeList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            edgeList.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(new Edge(to, time));
        }
        
        StringBuilder sb = new StringBuilder();
        if(bellmanFord(1)) {
            sb.append("-1\n");
        } else {
            for(int i=2; i<=N; i++) {
                sb.append(dist[i]==Integer.MAX_VALUE? -1:dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    // 반환 : 시간을 무한히 오래 전으로 되돌릴 수 있는가?
    static boolean bellmanFord(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        boolean updated = false;

        for(int i=1; i<N; i++) {
            updated = false;
            for(int j=1; j<=N; j++) {
                for(Edge edge: edgeList.get(j)) {
                    if(dist[j]!=Integer.MAX_VALUE && dist[edge.end] > dist[j]+edge.weight) {
                        dist[edge.end] = dist[j] + edge.weight;
                        updated = true;
                    }
                }
            }
            if(!updated) break;
        }

        if(updated) {
            for(int i=1; i<=N; i++) {
                for(Edge edge: edgeList.get(i)) {
                    if(dist[i]!=Integer.MAX_VALUE && dist[edge.end] > dist[i]+edge.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Edge {
        int end;
        int weight;
        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
