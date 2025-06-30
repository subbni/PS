import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int e3 = Integer.parseInt(st.nextToken());
            if (e1 == 0 && e2 == 0 && e3 == 0) break;

            if (e1 == e2 || e1 == e3 || e2 == e3) {
                sb.append("wrong\n");
                continue;
            }

            int longest = Math.max(e1, Math.max(e2, e3));
            int tmp = longest * longest;
            if (e1 != longest) {
                tmp -= (e1 * e1);
            }
            if (e2 != longest) {
                tmp -= (e2 * e2);
            }
            if (e3 != longest) {
                tmp -= (e3 * e3);
            }

            if (tmp == 0) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }

        System.out.println(sb);
    }
}