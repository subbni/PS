class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int middleIndex = queue1.length;
        int[] connectedQueue = new int[middleIndex * 2];
        long targetSum = 0L;

        // queue1과 queue2를 연결하며 전체 합을 구함
        for (int i = 0; i < middleIndex; i++) {
            connectedQueue[i] = queue1[i];
            connectedQueue[middleIndex + i] = queue2[i];
            targetSum += (queue1[i] + queue2[i]);
        }

        // 합이 홀수면 나눌 수 없으므로 -1 반환
        if (targetSum % 2 != 0) return -1;
        
        targetSum /= 2;

        return find(connectedQueue, targetSum, middleIndex);
    }

    public int find(int[] arr, long targetSum, int middleIndex) {
        int s = arr.length - 1, e = arr.length - 1;
        long sum = arr[arr.length - 1];
        int minOperations = Integer.MAX_VALUE;
        int cur;

        while (e >= 0) {
            if (sum < targetSum) {
                // sum이 targetSum보다 작을 때, s 인덱스를 감소시켜 sum에 추가
                if (s > 0) {
                    sum += arr[--s];
                } else {
                    sum -= arr[e--];
                }
            } else if (sum > targetSum) {
                // sum이 targetSum보다 클 때, e 인덱스를 감소시켜 sum에서 제거
                sum -= arr[e--];
            } else {
                // targetSum과 같을 때, 작업 횟수를 계산하고 minOperations 갱신
                cur = 0;
                if (e >= middleIndex) {
                    cur = e - (middleIndex - 1) + s;
                } else if (e < middleIndex - 1) {
                    cur = e + 1 + middleIndex + s;
                } else {
                    cur += s;
                }

                minOperations = Math.min(minOperations, cur);
                sum -= arr[e--];
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}