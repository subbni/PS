import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] card = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }
    int M = Integer.parseInt(br.readLine());
    int[] number = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }
    // card를 정렬한다.
    Arrays.sort(card);

    StringBuffer sb = new StringBuffer();
    for(int i=0; i<M; i++) {
      // 각 숫자 number[i]가 card에 몇 개 존재하는지 출력
      int upper = findUpperBound(card, number[i]);
      int lower = findLowerBound(card,number[i]);
      int diff =  upper - lower ;
      sb.append(diff+" ");
    }
    System.out.print(sb);
    br.close();
  }

  // 처음으로 value와 같거나 큰 숫자가 나오는 인덱스 반환
  public static int findLowerBound(int[] arr, int value) {
    int start = 0;
    int end = arr.length;
    while(start < end) {
      int mid = (start+end)/2;
      if(arr[mid] >= value) {
        end = mid;
      } else {
        start = mid+1;
      }
    }
    return start;
  }

  // value보다 큰 숫자가 나오는 인덱스 반환
  public static int findUpperBound(int[] arr, int value) {
    int start = 0;
    int end = arr.length; // arr.length-1가 아닌 arr.length여야 함 (ex. 예제 입력의 10의 경우 생각해보기)
    while(start < end) {
      int mid = (start+end)/2;
      if(arr[mid] > value) {
        end = mid;
      } else {
        start = mid+1;
      }
    }
    return start;
  }
}
