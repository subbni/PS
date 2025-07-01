import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 점수 : 점수/최고점*100
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores);
        int maxScore = scores[N-1];
        double sum = 0;
        for (int i=0 ; i<N; i++) {
            sum += (double) scores[i] / maxScore * 100;
        }

        double newAverage = sum / N;
        System.out.println(newAverage);
    }
}