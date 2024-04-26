import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Data {
        long sum;
        int cnt;
        public Data(long sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int answer = -1;

        Queue<Data> queue = new ArrayDeque<>();

        queue.add(new Data(a,1));

        while(!queue.isEmpty()) {
            Data data = queue.poll();
            if(data.sum == b) {
                answer = data.cnt;
                break;
            }
            if(data.sum*2 <= b) {
                queue.add(new Data(data.sum*2, data.cnt+1));
            } 
            if(Long.parseLong(data.sum+"1") <= b) {
                queue.add(new Data(Long.parseLong(data.sum+"1"), data.cnt+1));
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
