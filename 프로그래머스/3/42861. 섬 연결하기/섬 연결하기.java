import java.util.*;

class Solution {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        public int compareTo(Edge e) {
            return this.cost-e.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for(int i=0; i<costs.length; i++) {
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        int cost = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(find(edge.v1)!=find(edge.v2)) {
                union(edge.v1, edge.v2);
                cost+=edge.cost;
            }
        }
        return cost;
    }
    
    public int find(int number) {
        if(parent[number] == number) return number;
        else return parent[number] = find(parent[number]);
    }
    
    public void union(int v1, int v2) {
        int v1Parent = find(v1);
        int v2Parent = find(v2);
        if(v1Parent!=v2Parent) {
            parent[v1Parent] = v2Parent;
        }
    }
}