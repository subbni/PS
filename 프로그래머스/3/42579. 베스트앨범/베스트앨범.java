import java.util.*;

class Solution {
    
    static int MAX_MUSIC = 2;
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String,Integer> totalPlays = new HashMap<>();
        HashMap<String,ArrayList<Integer>> musicPerGenre = new HashMap<>();

        for(int i=0;i<genres.length;i++) {
            if(totalPlays.get(genres[i]) == null) {
                totalPlays.put(genres[i], 0);
                musicPerGenre.put(genres[i], new ArrayList<Integer>());
            }
            // 1. 각 장르당 재생횟수 합 저장
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0)+plays[i]);
            // 2. 장르 내 고유번호 저장
            musicPerGenre.get(genres[i]).add(i);
        }

        // 3. 재생 횟수가 많은 장르별로 정렬
        ArrayList<String> sortedGenreList = new ArrayList(totalPlays.keySet());
        Collections.sort(sortedGenreList, (s1,s2)-> totalPlays.get(s2)-totalPlays.get(s1));

        for(String genre : sortedGenreList) {
            ArrayList<Integer> musicList = musicPerGenre.get(genre);
            // 4. 장르 하나당 재생 횟수가 많은 노래별로 정렬, 재생 횟수가 같다면 고유 번호가 낮은 것 우선순위
            Collections.sort(musicList, (s1,s2)-> (
                plays[s2]-plays[s1] == 0 ? s1-s2 : plays[s2]-plays[s1]
            )
            );

            for(int i=0;i<Math.min(musicList.size(), MAX_MUSIC);i++) {
                answer.add(musicList.get(i));
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}