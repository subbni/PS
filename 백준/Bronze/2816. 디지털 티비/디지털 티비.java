import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
입력 : 채널의 수 N / 채널 이름들 순서대로
출력 : KBS1을 리스트 첫 번째, KBS2를 리스트 두 번째로 바꾸기 위해 눌러야 하는 버튼을 순서대로 출력

버튼 1 : 아래(i+1)로 이동
버튼 2 : 위(i-1)로 이동
버튼 3 : 현재 채널을 한 칸 아래로 이동시킴 (현재 i와 i+1를 switch)
버튼 4 : 현재 채널을 한 칸 위로 이동시킴 (현재 i와 i-1를 switch)

풀이 : 1과 4만 사용해도 최악의 경우 길이 400정도
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];
        int idxOfKBS1 = -1;
        int idxOfKBS2 = -1;
        for (int i=0; i<N; i++) {
            channels[i] = br.readLine();
            if (channels[i].equals("KBS1")) {
                idxOfKBS1 = i;
            }
            if (channels[i].equals("KBS2")) {
                idxOfKBS2 = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<idxOfKBS1; i++) {
            sb.append("1");
        }
        for(int i=0; i<idxOfKBS1; i++) {
            sb.append("4");
        }
        if (idxOfKBS1 > idxOfKBS2) idxOfKBS2++;
        for(int i=0; i<idxOfKBS2; i++) {
            sb.append("1");
        }
        for(int i=1; i<idxOfKBS2; i++) {
            sb.append("4");
        }
        System.out.println(sb);
    }
}