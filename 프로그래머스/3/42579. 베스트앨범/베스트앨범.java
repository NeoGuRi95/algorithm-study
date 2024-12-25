import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreInfo = new HashMap<>();
        Map<String, List<int[]>> playInfo = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            // genre
            if (genreInfo.containsKey(genre)) {
                genreInfo.put(genre, genreInfo.get(genre) + play);
            } else {
                genreInfo.put(genre, play);
            }
            // play
            if (!playInfo.containsKey(genre)) {
                playInfo.put(genre, new ArrayList<>());
            }
            playInfo.get(genre).add(new int[] {i, play});
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>(
            (o1, o2) -> o2.playCnt - o1.playCnt);
        int size = 0;
        for (String key:genreInfo.keySet()) {
            Genre genre = new Genre(key, genreInfo.get(key));
            pq.offer(genre);
            if (playInfo.get(key).size() < 2) {
                size += 1;
            } else {
                size += 2;
            }
        }
        
        int[] answer = new int[size];
        int idx = 0;
        
        while (!pq.isEmpty()) {
            Genre genre = pq.poll();
            List<int[]> list = playInfo.get(genre.name);
            Collections.sort(list, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
            if (list.size() < 2){
                answer[idx] = list.get(0)[0];
                idx += 1;
            } else {
                answer[idx] = list.get(0)[0];
                answer[idx + 1] = list.get(1)[0];
                idx += 2;
            }
        }
        
        return answer;
    }
    
    class Genre {
        String name;
        int playCnt;
        Genre(String name, int playCnt) {
            this.name = name;
            this.playCnt = playCnt;
        }
    }
}