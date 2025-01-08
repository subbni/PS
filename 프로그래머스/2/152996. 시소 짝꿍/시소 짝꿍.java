import java.util.*;

class Solution {
    public long solution(int[] weights) {
    long answer = 0;
    Arrays.sort(weights);
    int prevCnt = 0;
    for(int i=0; i<weights.length-1; i++) {
      if(i>0 && weights[i]==weights[i-1]) {
          answer+=(--prevCnt);
          continue;
      }
      // 몸무게가 weights[i]*2보다 작거나 같은 weight까지 확인
      int lastIdx = searchEndIdx(weights, 2*weights[i], i);
      prevCnt=0;
      for(int j=i+1;j<=lastIdx;j++) {
        if(weights[i]==weights[j] || weights[i]*2==weights[j] || weights[i]*3==weights[j]*2 || weights[i]*4==weights[j]*3) {
          prevCnt++;
        }
      }
      answer+=prevCnt;
    }
    return answer;
  } 

  public int searchEndIdx(int[] arr, int targetValue, int curIdx) {
    // curIdx+1 ~ 배열 마지막 원소중에서
    // targetValue보다 큰 값을 가지는 최초 원소 return 
    int start = curIdx;
    int end = arr.length-1;
    int mid;
    while(start<end) {
      mid = (start+end)/2;
      if(arr[mid]<=targetValue) {
        start = mid+1;
      } else {
        end = mid; // 조건을 만족한다고 판단, (mid-1)가 아닌 mid로 대입
      }
    }
    return start;
  }
}