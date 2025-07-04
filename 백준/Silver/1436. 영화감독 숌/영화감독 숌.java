import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 종말의 수 : 6이 적어도 3개 이상 연속으로 들어가는 수
// N번째로 작은 종말의 수를 찾아라

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int number = 666;
        while (count < N) {
            number++;
            if (String.valueOf(number).contains("666"))
                count++;
        }
        System.out.println(number);
    }
}