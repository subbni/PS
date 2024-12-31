import java.util.*;

class Solution {
    static HashSet<Character> skipSet;
    static char[] alphabet;
    public String solution(String s, String skip, int index) {
        skipSet = new HashSet<>();
        alphabet = new char[26];
        for(char c='a'; c<='z'; c++) {
            alphabet[c-'a'] = c;
        }
        for(char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(getAfterAlphabet(c, index));
        }
        return sb.toString();
    }
    
    public char getAfterAlphabet(char c, int num) {
        int left = num;
        int index = 0;
        while(left>0) {
            index++;
            char cur = alphabet[(c-'a'+index)%26];
            if(skipSet.contains(cur)) {
                continue;
            }
            left--;
        }
        return alphabet[(c-'a'+index)%26];
    }
}