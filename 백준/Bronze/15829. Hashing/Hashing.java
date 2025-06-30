import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력 : 문자열의 길이 L, 문자열 (영문 소문자로만 구성)
// 출력 : 주어진 해시 함수를 사용해 계산한 해시 값을 정수로 출력

// 해시 함수 :
// r = 31, M = 1234567891 일 때, 
// ( 정수(ex. a=1) * r^항의 번호 ) mod M

class Main {
    public static void main(String[] args) throws IOException {
        int r = 31;
        int M = 1234567891;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long answer = 0L;
        for (int i=0; i<length; i++) {
            answer += (input.charAt(i)-'a'+1) * Math.pow(r, i);
        }

        answer = answer % M;
        System.out.println(answer);
    }
}