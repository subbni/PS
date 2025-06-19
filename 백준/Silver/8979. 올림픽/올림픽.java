import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 입력 :
// 총 국가의 수 N, 등수를 알고싶은 국가 K(1부터 시작)
// 각 국가를 나태는 정수, 금 / 은 / 동메달의 수

// 출력 :
// 국가 K의 등수

// 풀이 : 금-은-동 개수로 정렬하는 Comparator 적용한 PriorityQueue 사용

class Main {
    static class Nation {
        int nation;
        int gold;
        int silver;
        int bronze;
        public Nation(int nation, int gold, int silver, int bronze) {
            this.nation = nation;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Nation> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.gold == n2.gold) {
                if (n1.silver == n2.silver) {
                    return n2.bronze - n1.bronze;
                } else {
                    return n2.silver - n1.silver;
                }
            } else {
                return n2.gold - n1.gold;
            }
        });
    
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            pq.add(new Nation(nation, gold, silver, bronze));
        }

        Nation previous = null;
        int rank = 1;
        while (!pq.isEmpty()) {
            Nation current = pq.remove();

            if (previous != null) {
                if ((previous.gold != current.gold) || (previous.silver != current.silver) || (previous.bronze != current.bronze)) {
                    rank = N-pq.size(); // 1등, 공동 2등 다음은 4등
                }
            }

            if (current.nation == K) {

                break;
            }

            previous = current;
        }

        System.out.println(rank);
    }

}