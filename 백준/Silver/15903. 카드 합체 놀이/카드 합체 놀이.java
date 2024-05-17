import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            minHeap.add(Long.parseLong(st.nextToken()));
        }
        while(m-->0) {
            long min1 = minHeap.poll();
            long min2 = minHeap.poll();
            minHeap.add(min1+min2);
            minHeap.add(min1+min2);
        }
        Long sum = 0l;
        while(!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        System.out.println(sum);
    }
}
