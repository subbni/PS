import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] number;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] operator; // 덧셈, 뺄셈, 곱셈, 나눗셈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[N];
        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0],0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    public static void dfs(int sum, int depth) {
        if(depth == N-1) {
            if(sum > max) {
                max = sum;
            }
            if(sum < min) {
                min = sum;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                dfs(operate(i,sum, number[depth+1]), depth+1);
                operator[i]++;
            }
        }
    }


    public static int operate(int operator, int operand1, int operand2) {
        int result;
        switch (operator) {
            case 0:
                result = operand1+operand2;
                break;
            case 1:
                result = operand1-operand2;
                break;
            case 2:
                result = operand1*operand2;
                break;
            case 3:
                result = operand1/operand2;
                break;
            default:
                throw new IllegalArgumentException("operator 범위 0 ~ 3");
        }
        return result;
    }
}
