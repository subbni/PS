import java.util.*;

class Solution {
     static public int solution(String[][] book_time) {
    // PriorityQueue : 각 방의 퇴실 시간이 빠른 순대로 정렬
    // 각 Stack : 퇴실 시간 + 10 저장
    PriorityQueue<Stack<Integer>> roomQueue = new PriorityQueue<>((q1,q2)-> {
      return q1.peek()-q2.peek();
    });
    Arrays.sort(book_time, (b1,b2)-> b1[0].compareTo(b2[0]));

    for(int i=0; i<book_time.length;i++) {
      int arriveMinutes = convertTimeToMinutes(book_time[i][0]);
      int leaveMinutes = convertTimeToMinutes(book_time[i][1]);
  
      if(roomQueue.size()>0 && roomQueue.peek().peek() <= arriveMinutes) {
        // 사용 가능한 방 존재
        Stack<Integer> availableRoom = roomQueue.poll();
        availableRoom.add(leaveMinutes+10);
        roomQueue.add(availableRoom);
      } else {
        // 사용 가능한 or 사용한 방 없음
        Stack<Integer> newRoom = new Stack<>();
        newRoom.add(leaveMinutes+10);
        roomQueue.add(newRoom);
      }
    }
    return roomQueue.size();
  }

  static public int convertTimeToMinutes(String time) {
    // time 형식: HH:MM
    String[] timeTokens = time.split(":");
    int result = Integer.parseInt(timeTokens[0])*60 + Integer.parseInt(timeTokens[1]);
    return result;
  }
}