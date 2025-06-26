import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력 : 정사각형 판의 한 변 길이 N
// N줄에 걸쳐 행렬 입력 (_는 공백, *는 칠해진 부분)
// 출력 : 심장이 위치한 행의 번호 x와 열의 번호 y를 공백으로 구분
// 왼쪽 팔, 오른쪽 팔, 왼쪽 다리, 오른쪽 다리의 길이를 공백으로 구분


class Main {
    final static char FILLED_SYMBOL = '*';
    final static char EMPTY_SYMBOL = '_';
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[N][N];
        boolean isHeadFound = false;
        int heartX=0;
        int heartY=0;
        for (int i=0; i<N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                if (row[j] == FILLED_SYMBOL) {
                    board[i][j] = true;
                    if (!isHeadFound) {
                        heartX = i+1;   
                        heartY = j;
                        isHeadFound = true;
                    }
                } else {
                    board[i][j] = false;
                }
            }
        }
        sb.append(heartX+1+" ");
        sb.append(heartY+1+"\n");

        int lenghtOfLeftArm = 0;
        for (int i=heartY-1; i>=0; i--) {
            if (!board[heartX][i]) break;
            lenghtOfLeftArm++;
        }
        sb.append(lenghtOfLeftArm+ " ");

        int lenghtOfRightArm = 0;
        for (int i=heartY+1; i<N; i++) {
            if (!board[heartX][i]) break;
            lenghtOfRightArm++;
        }
        sb.append(lenghtOfRightArm+ " ");

        int lenghtOfWaist = 0;
        int endXOfWaist = 0;
        for (int i=heartX+1; i<N; i++) {
            if (!board[i][heartY])  {
                endXOfWaist = i-1;
                break;
            }
            lenghtOfWaist++;
        }
        sb.append(lenghtOfWaist+ " ");

        int lenghtOfLeftLeg = 0;
        for (int i=endXOfWaist+1; i<N; i++) {
            if (!board[i][heartY-1]) break;
            lenghtOfLeftLeg++;
        }
        sb.append(lenghtOfLeftLeg+ " ");

        int lenghtOfRightLeg = 0;
        for (int i=endXOfWaist+1; i<N; i++) {
            if (!board[i][heartY+1]) break;
            lenghtOfRightLeg++;
        }
        sb.append(lenghtOfRightLeg);

        System.out.println(sb);
    }
}