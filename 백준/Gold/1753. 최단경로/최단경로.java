import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int v,e,k;
    static ArrayList<ArrayList<Node>> list;
    static int dist[];
    static class Node implements Comparable<Node> {
        int number;
        int weight;
        public Node(int end, int weight) {
            this.number = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        list = new ArrayList<>();
        for(int i=0; i<=v; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to,weight));
        }

        dijkstra(k, v);
        for(int i=1; i<=v; i++) {
            System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
        }

    }

    static void dijkstra(int start, int v) {
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        boolean[] check = new boolean[v+1];
        dist[start] = 0;
        q.add(new Node(start,0));

        while(!q.isEmpty()) {
            Node startNode = q.poll();
            int startNum = startNode.number;
            if(!check[startNum]) {
                check[startNum] = true;
                for(Node node: list.get(startNum)) {
                    if(!check[node.number] && dist[node.number] > (dist[startNum]+node.weight)) {
                        dist[node.number] =  (dist[startNum]+node.weight);
                        q.add(new Node(node.number,dist[node.number]));
                    }
                }
            }
        }
    }
}
