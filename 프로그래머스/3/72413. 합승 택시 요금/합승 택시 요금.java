import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
  static ArrayList<ArrayList<Path>> pathList;
  static int N; // vertex 개수
    
  static class Path implements Comparable<Path>{
    int to;
    int cost;
    public Path(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
    @Override
    public int compareTo(Path p) {
      return this.cost - p.cost;
    }
  }
    
  public int solution(int n, int s, int a, int b, int[][] fares) {
    // n : 지점 갯수, s : 출발 지점, a : a의 도착지점, b: b의 도착 지점
    N = n;
    pathList = new ArrayList<>();
    for(int i=0; i<=n; i++) {
      pathList.add(new ArrayList<>());
    }
    for(int i=0; i<fares.length; i++) {
      pathList.get(fares[i][0]).add(new Path(fares[i][1], fares[i][2]));
      pathList.get(fares[i][1]).add(new Path(fares[i][0], fares[i][2]));
    }
    int[] together = dijkstra(s);
    int[] toA = dijkstra(a);
    int[] toB = dijkstra(b);

    int max = Integer.MAX_VALUE;
    for(int i=1; i<=n; i++) {
      int totalCost = together[i] + toA[i] + toB[i];
      if(max > totalCost) {
        max = totalCost;
      }
    }
    return max;
  }

  public int[] dijkstra(int start) {
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
      
    PriorityQueue<Path> pq = new PriorityQueue<>();
    pq.add(new Path(start, 0));
      
    while(!pq.isEmpty()) {
      Path currentPath = pq.poll();
      int currentNode =  currentPath.to;
      for(Path path : pathList.get(currentPath.to)) {
        if(dist[path.to] > dist[currentNode] + path.cost) {
          dist[path.to] = dist[currentNode] + path.cost;
          pq.add(new Path(path.to, dist[path.to]));
        }
      }
    }
    return dist;
  }
}
