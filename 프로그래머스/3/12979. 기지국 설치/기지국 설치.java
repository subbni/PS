class Solution {
    public int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int start = 1;
        int end;
        for(int i=0; i<stations.length; i++) { 
          end = stations[i]-w-1;
          if(start <= end) {
            int numOfHouses = (end - start) + 1;
            cnt += (numOfHouses%(2*w+1) == 0? numOfHouses/(2*w+1) : numOfHouses/(2*w+1) +1);
          }
          start = stations[i]+w+1;
        }

        if(start <= n) {
            end = n;
          if(start <= end) {
            int numOfHouses = (end - start) + 1;
            cnt += (numOfHouses%(2*w+1) == 0? numOfHouses/(2*w+1) : numOfHouses/(2*w+1) +1);
          }
        }
        
        return cnt;
        }    
}