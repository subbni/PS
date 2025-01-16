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
    int[] arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    // 차이가 M 이상이면서 제일 작은 경우 : 각 원소 a에 대해서 b>=x+M인 수 중 가장 작은 수 찾기
    int min = Integer.MAX_VALUE;
    for(int i=0; i<N-1; i++) {
      int lowerBound = getLowerBound(arr, i+1, arr[i]+M);
      int diff = arr[lowerBound]-arr[i];
      if(diff>=M && diff<min) {
        min = arr[lowerBound]-arr[i];
      }
    }
    System.out.println(min);
  }
  
  public static int getLowerBound(int[] arr, int startIdx, int target) {
    // startIdx부터 시작해서, target보다 크거나 같은 수 중 가장 작은 수인 idx return
    int start = startIdx;
    int end = arr.length-1;
    while(start<end) {
      int mid = (start+end)/2;
      if(arr[mid]>=target) {
        end = mid;
      } else {
        start = mid+1;
      }
    }
    return start;
  }
}
