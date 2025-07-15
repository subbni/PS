import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 2^31 => int 범위 
// 최소힙 사용 => Priority Queue 사용

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int input = Integer.valueOf(br.readLine());
            if (input == 0) {
                sb.append(minHeap.isEmpty() ? "0" : minHeap.poll()).append("\n");
                continue;
            }
            minHeap.add(input);
        }

        System.out.print(sb);
    }
}