import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static int[][] tomato;
    static int M,N;
    static int leftTomato=0;
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        // M = 가로(열의 수), N = 세로(행의 수)
        int M = in.nextInt();
        int N = in.nextInt();
        tomato = new int[N][M];
        int count = 0;
        Queue<int []> q = new LinkedList<>();

        for(int n=0;n<N;n++) {
            for(int m=0;m<M;m++) {
                tomato[n][m] = in.nextInt();
                if(tomato[n][m]==0) leftTomato++; 
                else if(tomato[n][m]==1) q.add(new int[]{n,m});
            }
        }
 
        
        while(!q.isEmpty() && leftTomato!=0) {
            count++;
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();

                for(int j=0;j<4;j++) {
                    int ny = cur[0]+dy[j];
                    int nx = cur[1]+dx[j];
    
                    if(ny<0 || nx<0 || ny>=N || nx>=M || tomato[ny][nx]!=0) continue;

                    tomato[ny][nx]=1;
                    q.add(new int[]{ny,nx});
                    leftTomato--;
                }
            }
        }

        System.out.println(leftTomato==0? count:-1);
        in.close();
        
    }
}
