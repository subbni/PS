import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int M = in.nextInt();

        int[][] A = new int[N][M];
        StringBuffer sb = new StringBuffer("");

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                A[i][j] = in.nextInt();
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int c = in.nextInt();
                sb.append(String.valueOf(A[i][j]+c)).append(" ");
            }
            if(i!=N-1) sb.append("\n");
        }

        System.out.println(sb);
        in.close();
    }
}
