import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    HashMap<Integer,Integer> hm = new HashMap<>();
    int maxLenth = 1; int curLenth = 1;
    int start = 0; int end = 1;
    hm.put(arr[0], 1);
    while(start<=end && end<arr.length) {
      int curSum = hm.getOrDefault(arr[end],0);
      if(curSum+1 <= K) {
        hm.put(arr[end], curSum+1);
        end++;
        curLenth++;
      } else {
        hm.replace(arr[start], hm.get(arr[start])-1);
        start++;
        curLenth--;
      }
      if(maxLenth < curLenth) {
        maxLenth = curLenth;
      }
    }
    System.out.println(maxLenth);
  }
}
