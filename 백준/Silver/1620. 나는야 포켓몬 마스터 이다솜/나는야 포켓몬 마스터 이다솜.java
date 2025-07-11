import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// N개의 줄에 1~N번에 해당하는 포켓몬 이름이 입력으로 들어옴
// 문제가 알파벳으로 들어오면 포켓몬 번호를 출력,
// 문제가 숫자로만 들어오면 해당 포켓몬 번호의 문자를 출력

// 입력 : 포켓몬 개수 N, 문제의 개수 M
// ~N개의 줄 : 포켓몬 이름
// ~M개의 줄 : 맞춰야 하는 문제

// 자료구조
// X번째로 들어온 값을 빠르게 출력해야 함 => 배열
// 특정 값에 해당하는 번호를 빠르게 출력해야 함 => Map

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 배열, Map에 저장
        String[] pocketMons = new String[N + 1];
        HashMap<String, Integer> pocketMonMap = new HashMap<>();
        // 초기화
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            pocketMons[i + 1] = name;
            pocketMonMap.put(name, i + 1);
        }
        // M개의 문제
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input.matches("[0-9]+")) { // number 형식
                sb.append(pocketMons[Integer.parseInt(input)] + "\n");
            } else {
                sb.append(pocketMonMap.get(input) + "\n");
            }
        }
        System.out.println(sb);
    }
}