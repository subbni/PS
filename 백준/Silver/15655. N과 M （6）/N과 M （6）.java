import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N,M;
  static int[] comb;
  static int[] arr;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    comb = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    sb = new StringBuilder();
    func(0,0);
    System.out.print(sb);
    br.close();
  }

  public static void func(int cur, int idx) {
    if(idx == M) {
      for (int num : comb)  {
        sb.append(num).append(' ');
      }
      sb.append("\n");
      return;
    }
    for(int i=cur; i<N; i++) {
      comb[idx] = arr[i];
      func(i+1, idx+1);
    }
  }
}
