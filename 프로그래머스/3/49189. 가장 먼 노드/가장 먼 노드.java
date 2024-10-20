import java.util.*;

class Solution {
  static class Node {
    int index; // 노드 번호
    int distance; 
    public Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }
  }

  static public int solution(int n, int[][] edge) {
    int answer = 0;
    ArrayList<ArrayList<Node>> connectedList = new ArrayList<ArrayList<Node>>();

    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[1] = 0;

    for(int i=0; i<=n; i++) {
      connectedList.add(new ArrayList<>());
    }

    for(int i=0; i<edge.length; i++) {
        connectedList.get(edge[i][0]).add(new Node(edge[i][1],1));
        connectedList.get(edge[i][1]).add(new Node(edge[i][0],1));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
    pq.add(new Node(1,0));

    while(!pq.isEmpty()) {
      Node current = pq.poll();

      if(current.distance > dist[current.index]) {
        continue;
      }

      for(Node neighbor : connectedList.get(current.index)) {
        int newDist = dist[current.index] + neighbor.distance;
        if(newDist < dist[neighbor.index]) {
          dist[neighbor.index] = newDist;
          pq.add(new Node(neighbor.index, newDist));
        }
      }
    }

    int max = 0;
    for(int i=1; i<=n; i++) {
      if(dist[i]!=Integer.MAX_VALUE && dist[i]>max) {
        max = dist[i];
      }
    }

    for(int i=1; i<=n; i++) {
      if(dist[i] == max) {
        answer++;
      }
    }
    return answer;

    }
}
