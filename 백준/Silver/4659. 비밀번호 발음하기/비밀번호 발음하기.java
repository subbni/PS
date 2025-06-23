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

            if (!checkHasMustHaveAlphabet(password)) { // 조건 1
                isValidPassword = false;
            }
            if (!checkVowelAndConsonantInRow(password)) { // 조건 2
                isValidPassword = false;
            }
            if (!checkSameAlphabetInRow(password)) { // 조건 3
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

    public static boolean isEndCondition(String input) {
        if (input.equals("end")) {
            return true;
        }
        return false;
    }

    public static boolean checkHasMustHaveAlphabet(String password) {
        String after = password.replaceAll("[aeiou]", "");
        if (after.length() == password.length()) {
            return false;
        }
        return true;
    }

    public static boolean checkVowelAndConsonantInRow(String password) {
        int maxCntInRow = 3;
        int cntOfVowel = 0;
        int cntOfConsonant = 0;
        char[] alphabets = password.toCharArray();
        for (char alphabet : alphabets) {
            if (alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') {
                cntOfVowel++;
                cntOfConsonant = 0;
            } else {
                cntOfConsonant++;
                cntOfVowel = 0;
            }
            if (cntOfVowel >= maxCntInRow || cntOfConsonant >= maxCntInRow) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSameAlphabetInRow(String password) {
        char[] alphabets = password.toCharArray();
        char prevChar = ' ';
        for (char alphabet : alphabets) {
            if (prevChar == alphabet) {
                if (alphabet != 'e' && alphabet != 'o') {
                    return false;
                }
            } 
            prevChar = alphabet;
        }
        return true;
    }
}