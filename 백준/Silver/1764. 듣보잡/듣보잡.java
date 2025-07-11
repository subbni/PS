import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 입력 : 듣도 못한 사람 N, 보도 못한 사람 M
// 출력 : N명과 M명 중 겹치는 사람들을 이름의 사전순으로 출력

// 듣도 못한 사람들을 Set에 저장,
// 보도 못한 사람들을 Set에 있는 지 확인 후, PriorityQueue(이름 사전순)에 저장

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> nameSet = new HashSet<>();
        PriorityQueue<String> duplicatedNames = new PriorityQueue<>((n1, n2) -> {
            return n1.compareTo(n2);
        });
        // 듣도 못한 사람들 Set에 저장
        for (int i = 0; i < N; i++) {
            nameSet.add(br.readLine());
        }
        // 겹치는 사람들 PQ에 저장
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (nameSet.contains(name)) {
                duplicatedNames.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(duplicatedNames.size() + "\n");
        while (!duplicatedNames.isEmpty()) {
            sb.append(duplicatedNames.poll()+"\n");
        }
        System.out.println(sb);
    }
}