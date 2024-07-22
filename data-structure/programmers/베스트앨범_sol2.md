## 베스트앨범
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42579
* 시간 복잡도 : O(nlog(n))
```java
import java.util.*;

class Solution {
    class Music implements Comparable<Music> {
        private int playCount;
        private int order;
        
        public Music(int playCount, int order) {
            this.playCount = playCount;
            this.order = order;
        }
        
        @Override
        public int compareTo(Music other) {
            if (this.playCount == other.playCount) {
                return Integer.compare(order, other.order);
            }
            return Integer.compare(other.playCount, playCount);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalGenreMap = new HashMap<>();
        Map<String, PriorityQueue<Music>> genreMap = new HashMap<>();
        
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<plays.length; i++) {
            totalGenreMap.put(genres[i], totalGenreMap.getOrDefault(genres[i], 0) + plays[i]);
            
            PriorityQueue<Music> pq = genreMap.getOrDefault(genres[i], new PriorityQueue<>());
            pq.offer(new Music(plays[i], i));
            genreMap.put(genres[i], pq);
        }
        
        List<String> keys = new ArrayList<>(totalGenreMap.keySet());
        Collections.sort(keys, (o1, o2) -> Integer.compare(totalGenreMap.get(o2), totalGenreMap.get(o1)));
        
        for(String key : keys) {
            PriorityQueue<Music> pq = genreMap.getOrDefault(key, new PriorityQueue<>());
            if (pq.isEmpty()) continue;
            
            if (pq.size() >= 2) {
                answer.add(pq.poll().order);
            }
            answer.add(pq.poll().order);
            
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
```
