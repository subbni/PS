import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<Integer> DESC_pq = new PriorityQueue<>();
        PriorityQueue<Integer> ASC_pq = new PriorityQueue<>((o1,o2)->o2-o1);

        for(int i=0;i<operations.length;i++) {
            String[] operation = operations[i].split(" ");
            if(operation[0].equals("I")) {
                // 숫자 삽입
                DESC_pq.add(Integer.parseInt(operation[1]));
                ASC_pq.add(Integer.parseInt(operation[1]));

            } else if(!DESC_pq.isEmpty()) {
                int target;
                if(operation[1].equals("1")) {
                    // 최댓값 삭제
                    target = ASC_pq.poll();
                    DESC_pq.remove(target);
                } else {
                    // 최솟값 삭제
                    target = DESC_pq.poll();
                    ASC_pq.remove(target);
                }
            }
        }
        
        if(DESC_pq.isEmpty()) {
               answer = new int[] {0,0};
         } else {
               answer = new int[] {ASC_pq.poll(),DESC_pq.poll()};
          }
          
        return answer;
    }
}