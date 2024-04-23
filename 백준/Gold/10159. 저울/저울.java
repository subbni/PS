import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 물건의 개수
        int M = Integer.parseInt(br.readLine()); // 측정된 물건 쌍의 개수
        int[][] dist = new int[N+1][N+1];
        int[] answer = new int[N+1];
        StringTokenizer st;
        for(int i=1;i<=N;i++) {
            dist[i][i]=1;
        }
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavier = Integer.parseInt(st.nextToken());
            int lighter = Integer.parseInt(st.nextToken());
            dist[heavier][lighter] = 1;
            dist[lighter][heavier] = -1;
        }

        // i:중간   j:시작   k:끝
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(dist[j][i]==0) continue;
                for(int k=1; k<=N; k++) {
                    if(dist[i][k]==0) continue;
                    if(dist[j][i]<0 && dist[i][k]<0) {
                        if(dist[j][k] == 0) answer[j]++;
                        dist[j][k]=-1;
                    } else if(dist[j][i]>0 && dist[i][k]>0) {
                        if(dist[j][k] == 0) answer[j]++;
                        dist[j][k]=1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++) {
			int cnt=0;
			for(int j=1; j<N+1; j++) {
				if(dist[i][j] != 0) {
					cnt++;
				}
			}
			sb.append((N-cnt)+"\n");
			
		}
		System.out.println(sb.toString());
    }
}
