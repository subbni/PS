import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N의 분해합 : N + (N을 이루는 각 자리수의 합)
// 어떤 자연수 M의 분해합이 N인 경우 M은 N의 생성자이다.

// 출력 : N의 가장 작은 생성자 출력, 생성자가 없는 경우에는 0 출력

// M + (M을 이루는 각 자리수의 합) = N인 M을 찾아야 함
// [핵심] 자연수 N이 주어졌을때, N의 각 자리수의 합을 구하는 방법?

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = String.valueOf(N).length();
        int answer = 0;

        int minCadidate = getMinCandidate(length-1);
        for (int candidate=1; candidate<N; candidate++) {
            if (candidate + getEachSum(candidate) == N) {
                answer = candidate;
                break;
            }
        }

        System.out.println(answer);
    }

    public static int getEachSum(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static int getMinCandidate(int length) {
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += Math.pow(10, i) * 9;
        }
        return sum;
    }
}