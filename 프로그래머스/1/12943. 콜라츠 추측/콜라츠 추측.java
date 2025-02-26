class Solution {
    public int solution(int num) {
        if(num==1) return 0;
        int answer = 0;
        long tmp = (long)num;
        
        while(tmp>1 && answer<500) {
            if(tmp%2==0) tmp/=2;
            else tmp = tmp*3+1;
            
            answer++;
        }
        
        if(answer == 500) return -1;
        return answer;
    }
}