import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] selected = new int[d+1];
        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        // 쿠폰 초밥은 이미 먹었다고 가정
        selected[c] = 1;
        int cnt = 1;
        int max = 1;

        // 0~k-1까지 기본 초기화
        for(int i = 0; i<k; i++) {
            if(selected[sushi[i]] == 0) { // 
                cnt++;
            }
            selected[sushi[i]]++;
        }

        max = cnt;
        for(int i = 1; i<N; i++) { 
            // 현재 위치 i -> 범위의 첫 번째 위치가 됨
            // (i+k-1) % M -> 범위의 마지막 위치가 됨 (추가되는 위치)
            selected[sushi[i-1]]--;
            if(selected[sushi[i-1]] == 0) cnt--;
            selected[sushi[(i+k-1)%N]]++;
            if(selected[sushi[(i+k-1)%N]] == 1) cnt++;
            if(max < cnt) max = cnt;
        }

        System.out.println(max);
    }
}
