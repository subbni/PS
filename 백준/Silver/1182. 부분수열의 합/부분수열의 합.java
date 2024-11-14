import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, S;
  static int[] arr;
  static int cnt = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    func(0,0);
    if(S == 0) {
      cnt--; // 공집합인 경우 제외
    }
    System.out.println(cnt);
    br.close();
  }

  public static void func(int idx, int sum) {
    if(idx == N) {
      if(sum == S) {
        cnt++;
      }
      return;
    }
    func(idx+1, sum + arr[idx]); // idx번째 수를 부분수열에 포함
    func(idx+1, sum); // idx번째 수를 부분수열에 포함 X
  }
}
