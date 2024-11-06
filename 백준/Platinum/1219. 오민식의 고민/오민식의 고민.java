import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, M; // N: 정점 수 , M : edge 수
  static int start, end; // start : 시작지, end : 도착지
  static ArrayList<ArrayList<Edge>> connectList;
  static ArrayList<ArrayList<Edge>> reverseList;
  static boolean[] canReachToEnd;
  static long[] money;
  static long[] dist;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    canReachToEnd = new boolean[N];
    money = new long[N];

    // 정점 연결 list 초기화
    connectList = new ArrayList<>();
    reverseList = new ArrayList<>();
    for(int i=0; i<N; i++) {
      connectList.add(new ArrayList<>());
      reverseList.add(new ArrayList<>());
    }
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      connectList.get(from).add(new Edge(to, cost));
      reverseList.get(to).add(new Edge(from, cost));
    }

    // 얻을 수 있는 돈 정보 초기화
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      money[i] = Integer.parseInt(st.nextToken());
    }

    // 최장(?) 거리 테이블 초기화
    dist = new long[N];
    Arrays.fill(dist, Long.MIN_VALUE);
    
    StringBuffer sb = new StringBuffer();
    
    // end로 갈 수 있는 노드 정보 초기화
    markCanReachToEnd(end);

    // 벨만포드 실행
    boolean hasCycle = bellmanFord(start);
    if(dist[end]==Long.MIN_VALUE) {
      sb.append("gg");
    } else if(hasCycle) {
      sb.append("Gee");
    } else {
      sb.append(dist[end]);
    }
    System.out.println(sb);
    br.close();
  }

  // reserveList상에서 end 노드에서 도달 가능한 노드 마킹 <- connectList에서 end 노드로 도달 가능한 노드
  public static void markCanReachToEnd(int node) {
    canReachToEnd[node] = true;
    for (Edge edge : reverseList.get(node)) {
      if (!canReachToEnd[edge.to]) {
        markCanReachToEnd(edge.to);
      }
    }
  }

  // 반환 : 돈을 무한히 많이 가지고 있을 수 있는가?
  public static boolean bellmanFord(int start) {
    dist[start] = money[start];
    boolean updated = false;

    for(int i=1; i<=N; i++) {
      updated = false;
      for(int j=0; j<N; j++) {
        if(dist[j]==Long.MIN_VALUE) continue;
        for(Edge edge : connectList.get(j)) {
          if(dist[edge.to] < (dist[j] - edge.cost + money[edge.to])) {
            dist[edge.to] = dist[j] - edge.cost + money[edge.to];
            updated = true;
            if(i==N && canReachToEnd[edge.to]) {
              // N+1번째 반복
              return true;
            }
          }
        }
      }
      if(!updated) break;
    }

    return false;
  }

  static class Edge {
    int to;
    long cost;
    public Edge(int to, long cost) {
      this.to = to;
      this.cost = cost;
    }
  }
} 