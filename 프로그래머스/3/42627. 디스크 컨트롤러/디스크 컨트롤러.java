import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int jobs_idx=0, cur_time = 0;
        long sum_turnaround_time = 0;

        // 소요시간의 오름차순으로 정렬되는 Priorty Queue 
        PriorityQueue<Integer> pq = new PriorityQueue<>((j1,j2) -> jobs[j1][1]-jobs[j2][1]);

        // 1. jobs를 요청시간이 빠른 순으로 정렬 
        Arrays.sort(jobs, (j1,j2)->j1[0]-j2[0]);

        while(true) 
        {
            // jobs 에서 현재 시각 >= a 인 job이 있다면, Priorty Queue에 넣는다.
            for(;jobs_idx<jobs.length;jobs_idx++) {
                if(jobs[jobs_idx][0]>cur_time) break;
                pq.add(jobs_idx);
            }   

            if(jobs_idx==jobs.length && pq.isEmpty()) {
                // 종료 조건
                break;
            } else if(pq.isEmpty()) {
                // 현재 시각 이전에 들어온 요청이 없어 할 일이 없는 경우, 시간 뒤로 넘김 
                cur_time = jobs[jobs_idx][0];
            } else {
                // 처리할 요청이 밀려있는 경우, 소요시간이 제일 적은 job 실행
                int cur_idx = pq.poll();
                cur_time += jobs[cur_idx][1];
                sum_turnaround_time += (cur_time-jobs[cur_idx][0]);
            }
        }

        answer = Long.valueOf(sum_turnaround_time/jobs.length).intValue();
        return answer;
    }
}