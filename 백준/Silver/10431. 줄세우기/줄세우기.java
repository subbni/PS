import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            List<Integer> line = new ArrayList<>();
            for (int i=0; i<20; i++) {
                line.add(Integer.parseInt(st.nextToken())); 
            }

            int answer = 0;
            for (int i=1; i<20; i++) {
                for (int j=0; j<i; j++) {
                    if (line.get(j) > line.get(i)) {
                        int height = line.remove(i);
                        line.add(j, height);
                        answer += (i-j);
                        break;
                    }
                }
            }
            
            System.out.println(t+" "+answer);
        }
    }
}