class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow=Integer.MAX_VALUE;
        int maxRow=Integer.MIN_VALUE;
        int minCol=Integer.MAX_VALUE;
        int maxCol=Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++) {
            String row = wallpaper[i];
            for(int j=0; j<row.length(); j++) {
                if(row.charAt(j)=='#') {
                    minRow = minRow>i ? i : minRow;
                    maxRow = maxRow<i ? i : maxRow;
                    minCol = minCol>j ? j : minCol;
                    maxCol = maxCol<j ? j : maxCol;
                }
            }
        }
        int[] answer = {minRow, minCol, maxRow+1, maxCol+1};
        return answer;
    }
}