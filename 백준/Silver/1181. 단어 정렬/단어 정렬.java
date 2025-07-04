import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>( (s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            return s1.compareTo(s2);
        });

        for (int i = 0; i < N; i++) {
            pq.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        String prev = null;
        while (!pq.isEmpty()) {
            String cur = pq.poll();
            if (cur.equals(prev))
                continue;
            sb.append(cur + "\n");
            prev = cur;
        }

        System.out.print(sb);
    }
}