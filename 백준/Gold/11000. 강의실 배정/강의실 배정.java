import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        LinkedList<int[]> classList = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            classList.add(
                new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}
            );
        }
        Collections.sort(classList,(c1,c2) -> {
            if(c1[0]!=c2[0]) {
                return c1[0]-c2[0]; // 시작 시간이 빠른 순으로 정렬
            } else {    
                return c1[1]-c2[1]; // 시작 시간이 같다면 종료 시간이 빠른 순으로 정렬
            }
        });

        PriorityQueue<Integer> roomQ = new PriorityQueue<>(); 
        // 필요한 강의실. 해당 강의실에서 수업하는 강의가 마지막으로 끝나는 시간이 저장됨.
        int startTime = 0;
        int endTime = 0;
        for(int[] classInfo : classList) {
            startTime = classInfo[0];
            endTime = classInfo[1];
            if(!roomQ.isEmpty() && roomQ.peek() <= startTime) { 
                roomQ.poll(); // 현재 강의를 이 강의실에서 수행함을 의미, 업데이트를 위해 빼줌
            }
            roomQ.add(endTime); // 현재 강의가 끝나는 시간으로 업데이트 Or 강의실 추가
        }
        System.out.println(roomQ.size());
    }
}
