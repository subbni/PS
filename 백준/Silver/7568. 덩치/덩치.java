import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 덩치는 (몸무게, 키)로 나타낸다.
// 사람1의 덩치(a,b)와 사람2의 덩치(c,d)가 있을 때
// a>c && b>d 인 경우에만 사람1의 덩치가 사람2보다 크다고 할 수 있다.

// 각 사람의 덩치 등수는 자신보다 더 큰 덩치의 사람의 수에 의해 정해진다.

// 입력 : 전체 사람의 수 N, 각 줄마다 각 사람의 {몸무게 키}
// 출력 : 입력에 나열된 사람의 덩치 등수를 순서대로 출력 (공백문자로 분리)

// 풀이 : 몸무게 기준 오름차순 정렬 후 i번째 인덱스 사람에 대해 j=i+1 부터 확인하며
// 몸무게[i] < 몸무게[j] 이고 키[i] < 키[j]인 j를 카운트
// 시간복잡도 O(N^2)

class Main {
    static class Person {
        int number;
        int weight;
        int height;
        int rank;
        public Person(int number, int weight, int height) {
            this.number = number;
            this.weight = weight;
            this.height = height;
        }
        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Person[] persons = new Person[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Person person = new Person(i+1, weight, height);
            persons[i] = person;
        }

        Arrays.sort(persons, (p1, p2) -> {
            if (p1.weight != p2.weight) return p1.weight - p2.weight;
            return p2.height - p1.height;
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N; i++) {
            int weight = persons[i].weight;
            int height = persons[i].height;
            int cntOfBigPerson = 0;
            for (int j=i+1; j<N; j++) {
                if (weight < persons[j].weight && height < persons[j].height) {
                    cntOfBigPerson++;
                }
            }
            persons[i].setRank(cntOfBigPerson+1);
        }

        Arrays.sort(persons, (p1, p2) -> {
            return p1.number - p2.number;
        });

        for (Person person : persons) {
            sb.append(person.rank + " ");
        }

        System.out.println(sb);
    }
}