import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static char[] palindrome;
    static char[][] board;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=10; t++) {
            N = Integer.parseInt(br.readLine());
            board = new char[8][8];
            palindrome = new char[N];
            cnt = 0;
            for(int i=0; i<8; i++) {
                String[] line = br.readLine().split("");
                for(int j=0; j<8; j++) {
                    board[i][j] = line[j].charAt(0);
                }
            }
            checkRow();
            checkCol();
            sb.append("#"+t+" ").append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    static void checkRow() {
        for(int i=0; i<8; i++) { // 각 행에 대해서
            for(int j=0; j<=8-N; j++) { // 각 회문의 첫번째 위치
                for(int k=0; k<N; k++) {
                    palindrome[k] = board[i][j+k];
                }
                if(checkPalindrome()) cnt++; // 회문인지 확인 
            }
        }           
    }

    static void checkCol() {
        for(int i=0; i<8; i++) { // 각 열에 대해서
            for(int j=0; j<=8-N; j++) { // 각 회문의 첫번째 위치
                for(int k=0; k<N; k++) {
                    palindrome[k] = board[j+k][i];
                }
                if(checkPalindrome()) cnt++; // 회문인지 확인
            }
        }           
    }

    static boolean checkPalindrome() {
        int s = 0;
        int e = N-1;
        while(s<=e) {
            if(palindrome[s++]!=palindrome[e--]) {
                return false;
            }
        }
        return true;
    }
}
