import java.util.PriorityQueue;

public class Solution {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)-> {
            return o2-o1;
        });
        for(int i=0; i<works.length; i++) {
            maxHeap.add(works[i]);
        }
        while(maxHeap.isEmpty() || n-->0) {
            int max = maxHeap.poll();
            maxHeap.add(Math.max(max-1, 0));   
        }
        long answer = 0;
        while(!maxHeap.isEmpty()) {
            answer += Math.pow(maxHeap.poll(), 2);
        }
        return answer;
    }
}
