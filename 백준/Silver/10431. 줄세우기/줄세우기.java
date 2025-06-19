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
            
            int answer = 0;

            line.add(Integer.parseInt(st.nextToken()));
            for (int i=1; i<20; i++) {
                int currentHeight = Integer.parseInt(st.nextToken());

                int j=0;
                for (; j<i; j++) {
                    if (line.get(j) > currentHeight) {
                        answer += (i-j);
                        line.add(j,currentHeight);
                        break;
                    }
                }
                
                if (j==i) {
                    line.add(i, currentHeight);
                }
            }
            
            System.out.println(t+" "+answer);
        }
    }
}