import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 표의 크기
        int M = sc.nextInt(); // 계산 횟수
        int matrix[][] = new int[N][N];
        int preSum[][] = new int[N+1][N+1];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                preSum[i][j] = preSum[i][j-1]+matrix[i-1][j-1];
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int m=0;m<M;m++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int sum = 0;
            for(int i=x1;i<=x2;i++) {
                sum += (preSum[i][y2]-preSum[i][y1-1]);
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
