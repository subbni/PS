class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        
        // 스티커 배열의 길이가 1일 때 예외 처리
        if (n == 1) return sticker[0];

        // 첫 번째 스티커를 포함하는 경우 (마지막 스티커 포함 X)
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < n - 1; i++) { // n-1번째까지 (마지막 스티커는 포함 안 함)
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 첫 번째 스티커를 포함하지 않는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0; // 첫 번째 스티커를 포함하지 않음
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) { // 마지막 스티커까지 포함
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        // 두 경우 중 최댓값을 선택하여 반환
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}