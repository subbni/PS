import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] number = input.split("[-+]");
        Deque<Integer> numberQ = new ArrayDeque<>();
        char[] op = new char[number.length-1];

        int idx = 0;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i)=='-' || input.charAt(i)=='+') {
                op[idx++] = input.charAt(i);
            }
        }

        for(int i=number.length-1; i>0; i--) {
            if(op[i-1] == '+') {
                number[i-1] = String.valueOf(Integer.parseInt(number[i])+Integer.parseInt(number[i-1]));
            } else {
                numberQ.add(Integer.parseInt(number[i]));
            }
        }
        
        int result = Integer.parseInt(number[0]);
        while(!numberQ.isEmpty()) {
            result -= numberQ.removeLast();
        }

        System.out.println(result);
    }
}
