import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<ArrayList<Integer>> aList;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    aList = new ArrayList<>();
    for(int i=0; i<n+1; i++) {
      aList.add(new ArrayList<>());
    }

    String[] target = br.readLine().split(" ");
    int m = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      aList.get(parent).add(child);
      aList.get(child).add(parent);
    }

    visited = new boolean[n+1];
    int answer = find(Integer.parseInt(target[0]),Integer.parseInt(target[1]),0);
    System.out.println(answer);
    br.close();
  }

  public static int find(int current, int target, int sum) {
    if(current == target) {
      return sum;
    }
    visited[current] = true;
    for(int number : aList.get(current)) {
      if(!visited[number]) {
        int result = find(number,target,sum+1);
        if(result != -1) return result;
      }
    }
    return -1;
  }
}
