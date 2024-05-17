import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur>0)  {
                maxHeap.add(cur);
            } else {
                minHeap.add(cur);
            }
        }
        int sum = 0;
        while(maxHeap.size()>1) {
            int num1 = maxHeap.poll();
            int num2 = maxHeap.poll();
            sum += Math.max(num1*num2,num1+num2);
        }
        while(minHeap.size()>1) {
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();
            sum += num1*num2;
        }
        if(!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }
        if(!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        System.out.println(sum);
    }
}
