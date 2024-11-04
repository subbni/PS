import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int M, N, X;
  static int[] dist;
  static int[] reveresdDist; 
  static class Node implements Comparable<Node> {
    int number;
    int cost;
    public Node(int number, int cost) {
      this.number = number;
      this.cost = cost;
    }
    @Override
    public int compareTo(Node p) {
      return this.cost - p.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Node>> connectList = new ArrayList<>();
    ArrayList<ArrayList<Node>> reveresedConnectList = new ArrayList<>();

    for(int i=0; i<=N; i++) {
      connectList.add(new ArrayList<Node>());
      reveresedConnectList.add(new ArrayList<Node>());
    }

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      connectList.get(from).add(new Node(to, cost));
      reveresedConnectList.get(to).add(new Node(from, cost));
    }

    int distToGo[] = dijkstra(connectList);
    int distToGoBack[] = dijkstra(reveresedConnectList);

    int max = 0;
    for(int i=1; i<=N; i++) {
      if (distToGo[i] + distToGoBack[i] > max) {
        max = distToGo[i] + distToGoBack[i];
      }
    }

    System.out.println(max);
    br.close();
  }

  static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
    int dist[] = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[X] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    pq.add(new Node(X, 0));

    while(!pq.isEmpty()) {
      Node currentNode = pq.poll();
      int currentNumber = currentNode.number;
      
      for(Node node: list.get(currentNumber)) {
        if(dist[node.number] > dist[currentNumber] + node.cost) {
          dist[node.number] = dist[currentNumber] + node.cost;
          pq.add(new Node(node.number, dist[node.number]));
        }
      }
    }
    return dist;
  }
}
