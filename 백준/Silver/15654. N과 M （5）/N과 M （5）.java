import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  static int N,M;
  static StringBuilder sb;
  static int[] arr;
  static int[] comb;
  static boolean visited[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    comb = new int[M];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    // 모든 수를 오름차순 정렬
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
    for(int i=0; i<N; i++) {
      if(!visited[i]) {
        comb[idx] = arr[i];
        visited[i] = true;
        func(i, idx+1);
        visited[i] = false;
      }
    }
  }
}
