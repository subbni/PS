import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력 : 돌의 개수 N
// 출력 : 상근이가 이긴다면 SK, 창영이가 이긴다면 CY 출력

// 게임의 규칙
// 1. 턴을 번갈아가면서 돌을 1개 또는 3개 가져가고, 마지막 돌을 가져가는 사람이 이긴다.
// 2. 상근이가 먼저 가져간다.

// 풀이 : 숫자 N을 3과 1로 나누어 배치, ex) 5는 1/1/3 혹은 1/1/1/1/1/1
// 필요한 3과 1의 개수가 홀수일 경우 => 상근이가 이김
// 짝수일 경우 => 창영이가 이김

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int requiredNumber = N/3 + (N%3);
        if (requiredNumber%2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
        br.close();
    }
}