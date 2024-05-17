import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int cnt = 0;
        String cur = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(!arr[i].equals(cur)) {
                cnt++;
                cur = arr[i];
            }
        }
        if(cnt%2!=0) cnt+=1;
        System.out.println(cnt/2);
    }
}
