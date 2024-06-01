import java.util.*;

class Solution {
    static class Data {
        String word;
        int cnt;
        public Data(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    static public int solution(String begin, String target, String[] words) {
        Queue<Data> q = new ArrayDeque<>();
        HashSet<String> hs = new HashSet<>();
        int len = begin.length();
        for(int i=0; i<words.length; i++) {
            hs.add(words[i]);
        }
        hs.remove(begin);
        q.add(new Data(begin,0));
        int answer = 0;
        while(!q.isEmpty()) {
            Data data = q.poll();
            char[] arr = data.word.toCharArray();
            for(int i=0; i<len; i++) {
                if(answer != 0) break;
                for(char c='a'; c<='z'; c++) {
                    char tmp = arr[i];
                    if(tmp == c) continue;
                    arr[i] = c;
                    String curWord = new String(arr);
                    if(hs.contains(curWord)) {
                        if(curWord.equals(target)) {
                            answer = data.cnt + 1;
                            break;
                        } else {
                            q.add(new Data(new String(arr),data.cnt+1));
                            hs.remove(curWord);
                        }
                    }
                    arr[i] = tmp;
                }
            }
        }
        return answer;
    }
}