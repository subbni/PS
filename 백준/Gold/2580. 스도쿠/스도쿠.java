import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        matrix = new int[9][9];
        int last = 0;
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<9; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==0) last++;
            }
        }
        sudoku(last);
        System.out.println(sb);
    }

    public static boolean sudoku(int last) {
        if(last == 0) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(matrix[i][j]).append(' ');
                }
                sb.append('\n');
            }
            return true;
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(matrix[i][j]==0) {
                    // 두 정수에서 모두 0 비트를 가지는 수 부터
                    int bit1 = checkRowAndCol(i, j);
                    int bit2 = checkSquare(i,j);
                    int bit = bit1 | bit2;

                    for(int pos=1; pos<=9; pos++) {
                        if(((bit >> pos) & 1) == 0) {
                            matrix[i][j] = pos;
                            if(sudoku(last-1)) {
                                return true;
                            }
                            matrix[i][j] = 0;
                        }
                    }
                    if(matrix[i][j]==0) return false;
                }
            }
        }
        return false;
    }

    public static int checkRowAndCol(int row, int col) {
        // 가로 세로 범위 체크
        int bit = 0;
        for(int i=0; i<9; i++) {
            if(matrix[row][i]!=0) {
                bit = bit | (1 << matrix[row][i]);
            }
            if(matrix[i][col]!=0) {
                bit = bit |  (1 << matrix[i][col]);
            }
        }
        return bit;
    }

    public static int checkSquare(int row, int col) {
        // 정사각형 범위 체크
        int bit = 0;
        for(int i=(row/3)*3; i/3 == row/3; i++) {
            for(int j=(col/3)*3; j/3 == col/3; j++) {
                if(matrix[i][j]!=0) {
                    bit = bit | (1 << matrix[i][j]);
                }
            }
        }
        return bit;
    }
}
