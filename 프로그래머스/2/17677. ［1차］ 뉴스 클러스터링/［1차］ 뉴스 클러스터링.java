import java.util.HashMap;
class Solution {
    public int solution(String str1, String str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    HashMap<String,Integer> map1 = new HashMap<>();
    HashMap<String,Integer> map2 = new HashMap<>();

    // 1. map에 각 요소 넣기
    String regex = ".*[^a-z].*";
    for(int i=0; i<str1.length()-1;i++) {
      String piece;
      if(i+2==str1.length()) { // 2개씩 자르기
        piece = str1.substring(i);
      } else {
        piece = str1.substring(i,i+2);
      }
      // 유효한지 검증
      if(piece.matches(regex)) continue;
      map1.put(piece, map1.getOrDefault(piece, 0)+1);
    }
    for(int i=0; i<str2.length()-1;i++) {
      String piece;
      if(i+2==str2.length()) { // 2개씩 자르기
        piece = str2.substring(i);
      } else {
        piece = str2.substring(i,i+2);
      }
      // 유효한지 검증
      if(piece.matches(regex)) continue;
      map2.put(piece, map2.getOrDefault(piece, 0)+1);
    }

    // 공집합 처리
    if(map1.size()==0 && map2.size()==0) {
      return 65536;
    }

    // 2. 교집합 구하기
    int intersectionCnt = 0;
    for(String key : map1.keySet() ) {
      if(map2.containsKey(key)) {
        intersectionCnt += Math.min(map1.get(key), map2.get(key));
      }
    }

    // 3. 합집합 구하기
    int unionCnt = 0;
    for(Integer cnt : map1.values()) {
      unionCnt += cnt;
    }
    for(Integer cnt : map2.values()) {
      unionCnt += cnt;
    }
    unionCnt -= intersectionCnt;
        
    // 4. 정답 도출
    double answer = (double)intersectionCnt/unionCnt;
    return (int)(answer*65536);
  }
}