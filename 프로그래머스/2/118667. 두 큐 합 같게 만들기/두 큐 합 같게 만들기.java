class Solution {
    public int solution(int[] queue1, int[] queue2) {
    int middleIndex = queue1.length;
    // 1. queue1과 queue2를 이어서 새로운 queue를 만든다.
    int[] connectedQueue = new int[middleIndex*2];
    long targetSum = 0l;
    for(int i=0; i<middleIndex; i++) {
        connectedQueue[i]=queue1[i];
        connectedQueue[middleIndex+i]=queue2[i];
        targetSum += (queue1[i]+queue2[i]);
    }
    targetSum /= 2;
    
    return find(connectedQueue, targetSum);
    
}

    public int find(int[] arr, long targetSum) {
    int s=arr.length-1, e=arr.length-1;
    long sum = arr[arr.length-1];
    int[] idxArr = {-1, -1};
    int min = Integer.MAX_VALUE;
    int cur= 0;
    while(e>=0) {
        if(sum<targetSum) {
            if(s>0) {
                s--;    
                sum+=arr[s];
            } else {
                sum-=arr[e];
                e--;       
            }
        } else if(sum>targetSum) {
            sum-=arr[e];
            e--;
        } else {
            cur = 0;
            if(e >= arr.length/2) {
                cur = e - (arr.length/2-1);
                cur += s;
            } else {
                if(e < arr.length/2-1) {
                    cur = e+1;
                    cur += arr.length/2+s;
                } else {
                    cur += s;
                }
            }
            
            if(cur < min) {
                min = cur;
                idxArr[0]=s;
                idxArr[1]=e;
            }
            sum-=arr[e];
            e--;
        }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
}
}