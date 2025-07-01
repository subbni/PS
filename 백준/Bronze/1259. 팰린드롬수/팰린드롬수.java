import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팰린드롬 수 : 수의 숫자들을 뒤에서부터 읽어도 같아면 팰린드롬수

// 입력 : 마지막 줄에 0이 주어짐

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            int length = input.length();
            boolean isPalindrome = true;
            for (int i=0; i<length; i++) {
                if (input.charAt(i) != input.charAt(length-i-1)) {
                    isPalindrome = false;
                    break;
                }
            }
            sb.append( isPalindrome ? "yes" : "no");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}