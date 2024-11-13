import java.io.*;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String sentence;
    while(( sentence = br.readLine())!=null && !sentence.equals(".")) {
      Stack<Character> stack = new Stack<>();
      int i=0;
      for(; i<sentence.length(); i++) {
        char c = sentence.charAt(i);
        if(c == '(' || c=='[') {
          stack.add(c);
        } else if(c==')' || c==']') {
          if(stack.isEmpty() || !checkPairBracket(stack.pop(), c)) {
            break;
          }
        }
      }
      if(i==sentence.length() && stack.isEmpty()) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }
    }
    System.out.print(sb);
    br.close();
  }

  public static boolean checkPairBracket(char first, char second) {
    if(first == '(') {
      return second == ')';
    } else if(first == '[') {
      return second == ']';
    } else {
      throw new IllegalArgumentException();
    }
  }
}
