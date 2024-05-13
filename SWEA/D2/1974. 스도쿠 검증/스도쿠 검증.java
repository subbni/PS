import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            sudoku = new int[9][9];
            StringTokenizer st;
            for(int i=0; i<9; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            if(checkRow() && checkCol() && checkBox()) {
                result = 1;
            }
            sb.append("#"+t+" ").append(result).append('\n');
        }
        System.out.print(sb);
    }

    static boolean checkRow() {
        boolean[] check;
        for(int i=0; i<9; i++) {
            check = new boolean[10];
            for(int j=0; j<9; j++) {
                if(check[sudoku[i][j]]) {
                    return false;
                }
                check[sudoku[i][j]] = true;
            }
        }
        return true;
    }

    static boolean checkCol() {
        boolean[] check;
        for(int i=0; i<9; i++) {
            check = new boolean[10];
            for(int j=0; j<9; j++) {
                if(check[sudoku[j][i]]) {
                    return false;
                }
                check[sudoku[j][i]] = true;
            }
        }
        return true;
    }

    static boolean checkBox() {
        boolean[] check;
        for(int k=3; k<=9; k+=3) {
            check = new boolean[10];
            for(int i=k-3; i<k; i++) {
                for(int j=k-3; j<k; j++) {
                    if(check[sudoku[i][j]]) {
                        return false;
                    }
                    check[sudoku[i][j]] = true;
                }
            } 
        }
        return true;
    }
}
