import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=0; i<5; i++) {
            int num = Integer.parseInt(st.nextToken());
            num *= num;
            sum += num;
        }
        int answer = sum % 10;
        System.out.println(answer);
    }
}