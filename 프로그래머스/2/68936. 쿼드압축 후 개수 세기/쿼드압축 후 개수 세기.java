class Solution {
    static int[][] arr;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        process(0,0,arr.length);
        return answer;
    }
    
    public void process(int startX, int startY, int size) {
        if(allSameNumber(startX, startY, size)) {
            answer[arr[startX][startY]]++;
            return;
        }
        
        process(startX,startY,size/2);
        process(startX+size/2,startY,size/2);
        process(startX,startY+size/2,size/2);
        process(startX+size/2,startY+size/2,size/2);
    }
    
    public boolean allSameNumber(int startX, int startY, int size) {
        int number = arr[startX][startY];
        for(int i=0; i<size;i++) {
            for(int j=0; j<size; j++) {
                if(arr[startX+i][startY+j] != number) {
                    return false;
                }
            }
        }
        return true;
    }
}