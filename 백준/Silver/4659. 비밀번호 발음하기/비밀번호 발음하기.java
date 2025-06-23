import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력 : 여러 개의 테스트 케이스, 마지막 테스트 케이스는 "end"
// 출력 : 각 테스트 케이스가 주어진 비밀번호의 조건에 부합하는지 여부를 출력

// 조건
// 1. 모음 (a,e,i,o,u)를 만드시 하나 이상 포함
// 2. 모음 혹은 자음이 3개 연속으로 오면 안 됨
// 3. 같은 글자가 연속적으로 두번 오면 안 됨 (예외 : ee, oo)

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String password = br.readLine();
            boolean isValidPassword = true;

            if (isEndCondition(password)) break;

            if (!hasVowel(password)) { // 조건 1
                isValidPassword = false;
            } else if (!noThreeInRow(password)) { // 조건 2
                isValidPassword = false;
            } else if (!noInvalidRepeat(password)) { // 조건 3
                isValidPassword = false;
            }

            if (isValidPassword) {
                sb.append("<"+password+"> is acceptable.\n");
            } else {
                sb.append("<"+password+"> is not acceptable.\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isEndCondition(String input) {
        return "end".equals(input);
    }

    static boolean hasVowel(String password) {
        char[] alphabets = password.toCharArray();
        for (char alphabet : alphabets) {
            if ("aeiou".indexOf(alphabet) != -1) return true;
        }
        return false;
    }

    static boolean noThreeInRow(String password) {
        int cntOfVowel = 0;
        int cntOfConsonant = 0;
        for (char alphabet : password.toCharArray()) {
            if (isVowel(alphabet)) {
                cntOfVowel++;
                cntOfConsonant = 0;
            } else {
                cntOfConsonant++;
                cntOfVowel = 0;
            }
            if (cntOfVowel >= 3 || cntOfConsonant >= 3) return false;
        }
        return true;
    }

    static boolean noInvalidRepeat(String password) {
        for (int i = 1; i<password.length(); i++) {
            char prev = password.charAt(i-1);
            char cur = password.charAt(i);
            if (prev == cur && cur != 'e' && cur != 'o') return false;
        }
            return true;
    }

    static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}