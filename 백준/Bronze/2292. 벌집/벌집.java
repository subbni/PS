import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;

        if (N != 1) {
            int layer = 2;
            int maxNumOfLayer = 7;

            while (true) {
                answer ++;

                if (N > maxNumOfLayer) {
                maxNumOfLayer += 6 * layer;
                layer++;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}