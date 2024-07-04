import java.util.*;

class Solution {
    static class Car implements Comparable<Car> {
        int start;
        int end;
        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Car car) {
            int result = car.end - this.end;
            if(result == 0) {
                result = this.start - car.start;
            }
            return result;
        }
    }
    
    public int solution(int[][] routes) {
        ArrayList<Car> carList = new ArrayList<>();
        for(int i=0; i<routes.length; i++) {
            carList.add(new Car(routes[i][0],routes[i][1]));
        }
        Collections.sort(carList);
        
        int start = carList.get(0).start;
        int end = carList.get(0).end;
        int cnt = 1;
        for(int i=1; i<carList.size(); i++) {
            Car car = carList.get(i);
            if(car.end >= start) {
                end = car.end;
                start = Math.max(car.start,start);
            } else {
                // 아예 안 겹침
                cnt ++;
                end = car.end;
                start = car.start;
            }
        }
        return cnt;
    }
}