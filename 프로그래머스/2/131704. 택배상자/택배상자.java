import java.util.*;

class Solution {
    public int solution(int[] order) {
          Queue<Integer> container = new ArrayDeque<>();
        Stack<Integer> subContainer = new Stack<>();
        for(int i=1; i<=order.length; i++) {
            container.add(i);
        }
        
        int answer = 0;
        int i = 0;
        while(i < order.length) {
            if(!container.isEmpty() && order[i] == container.peek()) {
                container.poll();
                answer++; i++;
            } else if(subContainer.isEmpty() || order[i]>subContainer.peek()) {
                subContainer.add(container.poll());
            } else if(order[i] == subContainer.peek()) {
                subContainer.pop();
                answer++; i++;
            }  else {
                break;
            }
        }
        
        return answer;
    }
}