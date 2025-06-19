import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 입력 :
// 총 국가의 수 N, 등수를 알고싶은 국가 K(1부터 시작)
// 각 국가를 나태는 정수, 금 / 은 / 동메달의 수

// 출력 :
// 국가 K의 등수

// 풀이 : "금+은+동" 개수 String 사전순 반대로 Comparator 사용하기

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] medalStrings = new String[N+1];
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
    
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            String medalString = "";
            for (int j=0; j<3; j++) {
                medalString += st.nextToken();
            }
            medalStrings[nation] = medalString;
            pq.add(medalString);
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            String medalString = pq.remove();
            if (medalString.equals(medalStrings[K])) {
                break;
            }
            rank++;
        }

        System.out.println(rank);
    }
}