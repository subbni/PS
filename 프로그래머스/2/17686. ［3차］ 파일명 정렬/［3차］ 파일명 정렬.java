import java.util.*;
class Solution {
    static class FileName implements Comparable<FileName> {
        String fullName;
        String head;
        int number;
        String tail;
        
        public FileName(String fullName) {
            this.fullName = fullName;
            setParts();
        }

        private void setParts() {
            int endOfHeadIdx = 0;
            // head 추출
            while(!Character.isDigit(fullName.charAt(endOfHeadIdx))) {
                endOfHeadIdx ++;
            }
            head = fullName.substring(0,endOfHeadIdx).toLowerCase();
            // number 추출
            int endOfNumberIdx = endOfHeadIdx;
            while(endOfNumberIdx<fullName.length() && Character.isDigit(fullName.charAt(endOfNumberIdx))) {
                endOfNumberIdx ++;
            }
            number = Integer.parseInt(fullName.substring(endOfHeadIdx, endOfNumberIdx));
            // tail 추출
            if(endOfNumberIdx<fullName.length()) {
                tail = fullName.substring(endOfNumberIdx, fullName.length()).toLowerCase();
            } else {
                tail = null;
            }
        }

        int compareHead(String h1, String h2) {
            return h1.compareTo(h2);
        }

        int compareNumber(int n1, int n2) {
            return n1-n2;
        }

        @Override
        public int compareTo(FileName o) {
            int result = compareHead(head, o.head);
            if(result!=0) {
                return result;
            }
            return compareNumber(number, o.number);
        }
    }
    
    public String[] solution(String[] files) {
        ArrayList<FileName> fileNames = new ArrayList<>();
        String[] answerList = new String[files.length];
        for(int i=0; i<files.length; i++) {
            fileNames.add(new FileName(files[i]));
        }
        Collections.sort(fileNames);
        for(int i=0; i<files.length; i++) {
            answerList[i] = fileNames.get(i).fullName;
        }
        return answerList;
    }
}