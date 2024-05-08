import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=10; t++) {
            int cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)-> {
                return n2-n1;
            });
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int i=0; i<100; i++) {
                int num = Integer.parseInt(st.nextToken());
                maxHeap.add(num);
                minHeap.add(num);
            }

            int answer = maxHeap.peek() - minHeap.peek();
            while(cnt-->=0) {
                int max = maxHeap.poll();
                int min = minHeap.poll();
                answer = max-min;
                if(max-min<2) {
                    break;
                }
                maxHeap.add(max-1);
                minHeap.add(min+1);
            }

            sb.append("#"+t+" ").append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
