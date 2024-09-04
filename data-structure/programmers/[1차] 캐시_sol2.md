## [1차] 캐시
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17680
* 시간 복잡도 : O(n<sup>2</sup>logn)
```java
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new HashMap<>();
        int answer = 0, time = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.containsKey(city)) {
                answer++;
            } else {
                answer += 5;
                
                if (cacheSize > 0 && cache.size() >= cacheSize) {
                    List<String> cacheCities = new ArrayList<>(cache.keySet());
                    Collections.sort(cacheCities, (o1, o2) -> Integer.compare(cache.get(o1), cache.get(o2)));
                    cache.remove(cacheCities.get(0));
                }
            }
            if (cacheSize > 0) {
                cache.put(city, time);
            }
            time++;
        }
        return answer;
    }
}

```
