import java.util.Stack;
class Solution {
    boolean solution(String s) {
        
        char[] brackets = s.toCharArray();
        if(brackets.length%2!=0) return false;
        int cntLeft = 0;
        
        for(char bracket : brackets) {
            cntLeft += bracket==')'?-1:1;
            if(cntLeft<0) break;
        }
        
        return cntLeft==0? true:false;
    }
}