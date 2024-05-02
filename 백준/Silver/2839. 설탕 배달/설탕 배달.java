import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while(n > 0) {
            if(n%5 == 0) {
                result += n/5;
                break;
            } else {
                n -= 3;
                result ++;
            }
            if(n < 0) {
                result = -1;
                break;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
