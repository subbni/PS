import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 입력 : 주어질 연산의 수 M / 그 이후 한 줄씩 연산들
// 출력 : 연산을 순서대로 출력하다가 check 연산이 주어지면 결과를 출력

// 연산
// add x : x를 추가, 있으면 무시
// remove x : x를 제거, 없으면 무시
// check x : x가 있으면 1, 없으면 0 출력
// toggle x : x가 있으면 제거, 없으면 추가
// all : 원소 {1,2,...,20} 추가
// empty : 원소 모두 제거

// 풀이 : Set 자료구조를 이용하여 간단하게 풀이, 시간 복잡도 O(N)

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    
        Set<Integer> numbers = new HashSet<>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("all")) {
                addAll(numbers);
                continue;
            } else if (command.equals("empty")) {
                numbers.clear();
                continue;
            }

            int target = Integer.parseInt(st.nextToken());
            
            if (command.equals("add")) {
              numbers.add(target);
            } else if (command.equals("remove")) {
              numbers.remove(target);
            } else if (command.equals("toggle")) {
              if(!numbers.remove(target)) {
                numbers.add(target);
              }
            } else if (command.equals("check")) {
              int flag = numbers.contains(target) ? 1 : 0;
              sb.append(flag+"\n");
            }
        }   
        System.out.print(sb);
        br.close();
    }

    public static void addAll(Set<Integer> numbers) {
        for (int i=1; i<=20; i++) {
            numbers.add(i);
        }
    }
}