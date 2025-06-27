import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4의 배수이면서, 100의 배수가 아닐 때
// 혹은 400의 배수일 때

// 출력 : 윤년이면 1, 아니면 0 
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        int answer = 0;
        if (year % 400 == 0) {
            answer = 1;
        } else if (year % 4 == 0 && year % 100 != 0) {
            answer = 1;
        }
        System.out.println(answer);
    }
}