class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            answer[i] = func(numbers[i]);
        }
        return answer;
    }
    
    public long func(long x) {
        long result = x;
        // 가장 오른쪽 비트에서부터 시작해서
        for(long i=1;; i=(i<<1)) {
            if((result & i) == 0) { // x의 비트가 0이면
                result = (result | i); // 해당 위치의 0을 1로 바꿔주고
                result = (result ^ (i>>1)); // 이전 비트를 1에서 0으로 바꿔준다.
                break;
            }
        }
        return result;
    }
    
}