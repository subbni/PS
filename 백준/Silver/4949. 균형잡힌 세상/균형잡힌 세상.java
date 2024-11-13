import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String sentence;
    
    while((sentence = br.readLine()) != null && !sentence.equals(".")) {
      Stack<Character> stack = new Stack<>();
      boolean isBalanced = true;
      
      for (int i = 0; i < sentence.length(); i++) {
        char c = sentence.charAt(i);
        if (c == '(' || c == '[') {
          stack.push(c);
        } else if (c == ')' || c == ']') {
          if (stack.isEmpty() || !checkPairBracket(stack.pop(), c)) {
            isBalanced = false;
            break;
          }
        }
      }
      
      if (isBalanced && stack.isEmpty()) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }
    }
    
    System.out.print(sb);
    br.close();
  }

  public static boolean checkPairBracket(char open, char close) {
    return (open == '(' && close == ')') || (open == '[' && close == ']');
  }
}