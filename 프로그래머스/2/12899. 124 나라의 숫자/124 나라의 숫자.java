class Solution {
  static int[] suffix = {4, 1, 2};
    
  public String solution(int n) {
    StringBuilder sb = new StringBuilder();
    while(n>0) {
        sb.append(suffix[n%3]);
        n = (n-1)/3;
    }     
    return sb.reverse().toString();
  }
}