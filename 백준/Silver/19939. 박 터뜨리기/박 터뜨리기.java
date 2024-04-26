import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sigma = getSigma(k);
        if(n<sigma) {
            bw.write(-1+"");
        } else {
            int dif = k-1;
            if((n-sigma)%k != 0) {
                dif++;
            }
            bw.write(dif+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int getSigma(int n) {
        int result = 0;
        for(int i=1; i<=n; i++) {
            result += i;
        }
        return result;
    }

}
