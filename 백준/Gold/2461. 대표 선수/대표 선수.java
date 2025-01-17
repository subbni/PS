import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] classes = new int[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        classes[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[] indexs = new int[N];
    for(int i=0; i<N; i++) {
      Arrays.sort(classes[i]);
    }
    int min = Integer.MAX_VALUE;
    while(true) {

      int curMax = classes[0][indexs[0]];
      int curMin = classes[0][indexs[0]];
      int minClassIdx = 0;
      for(int i=1; i<N; i++) {
        if(classes[i][indexs[i]]>curMax) { // 현재 반 중 최댓값
          curMax = classes[i][indexs[i]];
        } else if(classes[i][indexs[i]]<curMin) { // 현재 반 중 최솟값
          curMin = classes[i][indexs[i]];
          minClassIdx = i;
        }
      }
      // 현재 인덱스가 가르키는 각 반의 수의 최대값 - 최소값 < min라면? 갱신
      if(curMax-curMin < min) {
        min = curMax-curMin;
      }
      if(++indexs[minClassIdx]>=M) {
        break;
      }
    }
    System.out.println(min);
  }
}
