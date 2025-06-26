import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 입력 : 플레이 신청 횟수 N, 플레이할 게임 종류 (Y/F/O)
// 다음 N 줄에서 플레이 신청한 사람들의 이름이 주어짐
// 출력 : 게임을 플레이할 수 있는 최대 횟수

// 풀이 :
// 1. 모든 이름을 HashSet에 넣는다.
// 2. 정답 = 게임 종류 (Y, F, O)에 따라 "Set의 크기 / (필요한 인원수-1)"

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> requestingPeople = new HashSet<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            requestingPeople.add(st.nextToken());
        }

        int answer = requestingPeople.size() / (getNeededCntofPeopleToPlay(game)-1);
        System.out.println(answer);
    }

    public static int getNeededCntofPeopleToPlay(String game) {
        switch (game) {
            case "Y":
                return 2;
            case "F":
                return 3;
            case "O":
                return 4;
            default:
                throw new IllegalArgumentException();
        }
    }
}