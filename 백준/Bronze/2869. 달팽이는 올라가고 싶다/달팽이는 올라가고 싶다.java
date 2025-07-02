import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력 : 낮에 올라갈 수 있는 A미터, 밤에 미끄러지는 B미터, 나무 막대 높이 V미터
// 출력 : 달팽이가 나무 막대 정상에 가려면 며칠이 걸리는 지

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        int answer = (V-B) / (A-B);
        if ((V-B) % (A-B) != 0) answer++;

        System.out.println(answer);
    }
}