import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 입력 : 알파벳 대소문자로 된 단어
// 출력 : 가장 많이 사용된 알파벳 (대소문자 구분 X), 여러 개 존재할 경우에는 ? 출력
// 고민 : 내림차순으로 정렬 어케하더라..?

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase();

        char[] alpabets = word.toCharArray();
        int[] cnt = new int['Z'-'A'+1];
        
        int maxIdx = 0;
        for(int i=0; i<alpabets.length; i++) {

            cnt[alpabets[i]-'A']++;
            if (cnt[maxIdx] < cnt[alpabets[i]-'A']) {
                maxIdx = alpabets[i]-'A';
            }
        }

        Arrays.sort(cnt);
        if (cnt[cnt.length-1] == cnt[cnt.length-2]) {
            System.out.println("?");
        } else {
            System.out.println((char)('A'+maxIdx));
        }
    }
}