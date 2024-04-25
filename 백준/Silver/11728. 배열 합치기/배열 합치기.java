import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());
        int arr1[] = new int[n];
        int arr2[] = new int[m];
        int resultArr[] = new int[n+m];

        // 배열 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 두 배열 합치기
        int p1 = 0, p2 = 0;
        int idx = 0;
        while(p1<n && p2<m) {
            if(arr1[p1] == arr2[p2]) {
                resultArr[idx] = arr1[p1];
                idx++;
                p1++;
            } else if(arr1[p1] < arr2[p2]) {
                resultArr[idx] = arr1[p1];
                idx++; 
                p1++;
            } else {
                resultArr[idx] = arr2[p2];
                idx++;
                p2++;
            }
        }
        
        // 남은 배열 처리
        while(p1<n) {
            resultArr[idx] = arr1[p1];
            idx++; 
            p1++;
        }
        while(p2<m) {
            resultArr[idx] = arr2[p2];
            idx++;
            p2++;
        }

        // 출력
        for(int i=0; i<resultArr.length; i++) {
            bw.write(resultArr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
