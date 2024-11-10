class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start=0, end=0, len=k+1, sum=sequence[0];
        while(start<sequence.length) {
            if(sum<k) {
                if(end<sequence.length-1) {
                    end++;    
                    sum+=sequence[end];
                } else {
                    start++;
                }
            } else if(sum>k) {
                sum-=sequence[start];
                start++;
            } else {
                if(end-start+1 < len) {
                    len=end-start+1;
                    answer[0]=start;
                    answer[1]=end;                          
                }
                sum-=sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}