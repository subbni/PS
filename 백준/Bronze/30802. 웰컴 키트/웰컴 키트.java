import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 티셔츠는 남아도 되지만 부족하면 안 된다.
// 연필은 정확히 참가자 수만큼 준비되어야 한다.

// 티셔츠는 같은 사이즈로 T장씩 주문할 수 있다.
// 펜은 P자루씩 주문하거나, 한 개씩 주문할 수 있다.

// 티셔츠 : 각 사이즈별로 𝛴 (신청자 수(X) / T) + 1
// 펜 : (N/P) + (N%P)

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T, P;
        int[] requestOfTshirt = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<6; i++) {
            requestOfTshirt[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        // --- 초기화

        int tshirtOrder = 0;
        for (int i=0; i<6; i++) {
            tshirtOrder += requestOfTshirt[i] / T;
            if (requestOfTshirt[i] % T != 0) tshirtOrder++;
        }

        System.out.println(tshirtOrder);
        System.out.println((N/P)+" "+(N%P));
    }
}