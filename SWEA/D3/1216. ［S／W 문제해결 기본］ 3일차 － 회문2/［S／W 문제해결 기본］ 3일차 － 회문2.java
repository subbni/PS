import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			int tc = Integer.parseInt(br.readLine());
			board = new char[100][100];
			for(int i=0; i<100; i++) {
				String[] line = br.readLine().split("");
				for(int j=0; j<100; j++) {
					board[i][j] = line[j].charAt(0);
				}
			}
			sb.append("#"+tc+" ").append(findLongestPalindrome()).append('\n');
		}
		System.out.print(sb);
	}
	
	public static int findLongestPalindrome() {
		int len = 100;
		for(; len>1; len--) {
			for(int r=0; r<100; r++) {
				for(int c=0; c+len-1<100; c++) {
					// board[r][c] ~ board[r][c+len-1] 확인
					if(checkRow(r,c,c+len-1) || checkCol(r,c,c+len-1)) {
						return len;
					}
				}
			}		
		}
		return len;
	}
    
	// 회문인지 확인
	public static boolean checkRow(int row, int start, int end) {
		int s=start, e=end;
		while(s<=e) {
			if(board[row][s] != board[row][e]) return false;
			s++;
			e--;
		}
		return true;
	}
	
	public static boolean checkCol(int col, int start, int end) {
		int s=start, e=end;
		while(s<=e) {
			if(board[s][col] != board[e][col]) return false;
			s++;
			e--;
		}
		return true;
	}
}
