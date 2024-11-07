class Solution {
    public String solution(String number, int k) {
        char[] charNumber = number.toCharArray();
        StringBuilder sb = new StringBuilder(number);
        int leftCntToRemove = k;
        for(int i=0; i<charNumber.length && leftCntToRemove>0; i++) {
            int curNum = charNumber[i];
            for(int j=1; j<=leftCntToRemove && i+j<charNumber.length; j++) {
                if(curNum < charNumber[i+j]) {
                    sb.setCharAt(i, '@');
                    leftCntToRemove--;
                    break;
                }
            }
        }
        
        for(int i=sb.length()-1; leftCntToRemove > 0; i--) {
            if(sb.charAt(i)!='@') {
                sb.setCharAt(i,'@');
                leftCntToRemove--;
            }
        }
        
        return sb.toString().replaceAll("@", "");
    }
}