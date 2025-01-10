import java.util.Arrays;

class Solution {  
  public int solution(int[] arrayA, int[] arrayB) {
     // 최소값을 찾는다.
    Arrays.sort(arrayA);
    Arrays.sort(arrayB);
    int minA = arrayA[0];
    int minB = arrayB[0];
     // 최소값의 약수 중, 조건을 만족하는 것이 있는 지 찾는다.
    int divisorA = 0;
    for(int i=minA; i>=2; i--) {
      if(minA%i == 0) {
        if(canDivideAll(i, arrayA) && cannotDivideAll(i, arrayB)) {
          divisorA = i; break;
        }
      }
    }
    int divisorB = 0;
   for(int i=minB; i>=2; i--) {
      if(minB%i == 0) {
        if(canDivideAll(i, arrayB) && cannotDivideAll(i, arrayA)) {
          divisorB = i; break;
        }
      }
    }
      int divisor = Math.max(divisorA, divisorB);
      
    return divisor;

  }
  public boolean canDivideAll(int number, int[] arr) {
    for(int i=0; i<arr.length; i++) {
      if(arr[i]%number!=0) {
        return false;
      }
    }
    return true;
  }
  public boolean cannotDivideAll(int number, int[] arr) {
    for(int i=0; i<arr.length; i++) {
      if(arr[i]%number==0) {
        return false;
      }
    }
    return true;
  }
}
