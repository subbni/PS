import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력 : 
// 정사각형 종이의 한 변의 길이 N
// 전체 칸의 색깔

// 출력 : 
// 잘라진 하얀색 색종이와 파란색 색종이의 개수

// 규칙 : 
// 전체 종이가 모두 같은 색이 아니라면 4등분
// 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지

// 풀이 :
// 현재 종이의 전체 칸이 같은 색인지 확인하는 로직 필요
// 현재 종이를 4등분하는 로직 필요

class Main {
    static int[] cnt;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 한 변의 길이
        paper = new int[N][N];
        cnt = new int[2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) { // 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkPaper(0, 0, N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }
    
    static public void checkPaper(int startX, int startY, int length) {
        if (checkAllSameColor(startX, startY, length)) {
            cnt[paper[startX][startY]]++;
            return;
        }
    
        checkPaper(startX, startY, length/2);
        checkPaper(startX + length/2, startY, length/2);
        checkPaper(startX, startY + length/2, length/2);
        checkPaper(startX+ length/2, startY + length/2, length/2);
    }

    static public boolean checkAllSameColor(int startX, int startY, int lenght) {
        if (lenght == 1) {
            return true;
        }
        int color = paper[startX][startY];
        for (int i = startX; i < startX + lenght; i++) {
            for (int j = startY; j < startY + lenght; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}