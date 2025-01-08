import java.util.*;
class Solution {
    public int solution(String s) {
        if(s.length()%2!=0) return 0;

        int answer = 0; 
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> bracketMap = new HashMap<>();
        bracketMap.put('}','{');
        bracketMap.put(']','[');
        bracketMap.put(')','(');
        
        for(int i=0;i<s.length();i++) {
            String rotatedStr = s.substring(i)+s.substring(0,i);
            stack.clear();
            
            for(char c: rotatedStr.toCharArray()) {
                if(stack.isEmpty() || stack.peek()==c) {
                    stack.push(c);
                }else{
                    if(bracketMap.containsKey(c) && bracketMap.get(c)==stack.peek()) stack.pop();
                    else stack.push(c);
                }
            }
            if(stack.isEmpty()) answer++;
        } 
        return answer;
    }
}