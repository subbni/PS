import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N장의 카드 중 targetNumber를 넘지 않으면서 그 수에 최대한 가까운 카드 3장의 합을 구해 출력

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int targetNumber = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int answer = 0;
        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum < targetNumber) {
                    int remain = (targetNumber - sum);
                    int anotherIdx = binarySearch(numbers, remain);
                    int curSum = sum + numbers[anotherIdx];
                    if (curSum > targetNumber && anotherIdx > 0) {
                        curSum = sum + numbers[anotherIdx-1];
                        anotherIdx = anotherIdx - 1;
                    }
                    if (anotherIdx != i && anotherIdx != j && curSum <= targetNumber) {
                        if (answer < curSum) answer = curSum;
                    }
                }
            }
            if (answer == targetNumber) break;
        }

        System.out.println(answer);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid+1;
            } else if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return left;
    }
}