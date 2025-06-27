import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력 : 리스트에 있는 점수 개수 N, 새로운 점수, 랭킹에 오를 수 있는 점수 개수 P 
// 현재 랭킹 리스트에 있는 점수들 (공백 구분)

// 출력 : 새로운 점수가 랭킹 리스트에서 몇 등인지 출력, 랭킹에 오를 수 없다면 -1 출력

// 같은 점수가 있을 때, 점수의 등수 주에 가장 작은 등수가 된다.

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(1);
            return;
        }

        // 각각의 점수가 몇 등인지를 전부 찾아야 함
        st = new StringTokenizer(br.readLine());

        int answer = -1;
        int prevScore = Integer.MAX_VALUE;
        int remainingCnt = P;
        int rank = 0;
        for (int i=0; i<=N; i++) {
            if (remainingCnt <= 0) break;
            if (i == N) { 
                answer = prevScore == newScore ? rank : i+1;
                break;
            }

            int curScore = Integer.parseInt(st.nextToken());
            if (curScore < newScore) {
                answer = prevScore == newScore ? rank : i+1;
                break;
            }

            if (prevScore > curScore) { // 순위 갱신
                rank = i+1;
            }

            prevScore = curScore;
            remainingCnt--;
        }

        System.out.println(answer);
    }
}