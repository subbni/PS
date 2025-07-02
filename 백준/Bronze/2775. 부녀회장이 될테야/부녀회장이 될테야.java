import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력 : 테스트케이스 T, 첫 번째 줄에 k층, 두 번재 줄에 n호가 각 케이스마다 주어짐
// 출력 : 테스트케이스마다 해당 집의 거주민 수를 출력

// a층의 b호에 살려면 자신의 아래층의 1호부터 b호까지 사는 사람들의 수의 합만큼 거주해야 함
// 아파트에는 0층부터 있고 각 층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
// 1층 1호는 0층의 1호 = 1
// 1층 2호는 0층의 (1+2)호 = 1+2 = 3
// 1층 3호는 0층의 (1+2+3)호 = 1+2+3 = 6
// 1층 n호는 n(n+1)/2 만큼의 사람이 거주해야 함
// 2층 1호는 1층의 1호 = 1
// 2층 2호는 1층의 (1+2)호 = 1+(1+2) = 4
// 2층 3호는 1층의 (1+2+3)호 = 1+(1+2)+(1+2+3) = 10
// 3층 1호는 2층의 1호 = 1
// 3층 2호는 2층의 (1+2)호 = 1+(1+(1+2)) = 5
// 3층 3호는 2층의 (1+2+3)호 = 1+4+10 = 15

class Main {
    static int[][] requiredPeoples;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++) {
            int floor = Integer.parseInt(br.readLine());
            int unit = Integer.parseInt(br.readLine());
            requiredPeoples = new int[floor+1][unit+1];
            int requiredPeople = getRequiredPeople(floor, unit);
            sb.append(requiredPeople+"\n");
        }

        System.out.println(sb);
    }

    public static int getRequiredPeople(int floor, int unit) {
        if (floor == 1) return unit * (unit+1) / 2;
        if (requiredPeoples[floor][unit]!=0) return requiredPeoples[floor][unit];

        int sum = 0;
        for (int i=1; i<=unit; i++) {
            sum += getRequiredPeople(floor-1, i);
        }

        return requiredPeoples[floor][unit] = sum;
    }
}