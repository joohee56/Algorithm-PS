## 보석 쇼핑
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67258
* 시간 복잡도 : O(nlogn)
```java
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        
        int gemTypeCount = gemSet.size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff1 = o1[1] - o1[0];
                int diff2 = o2[1] - o2[0];
                if (diff1 == diff2) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(diff1, diff2);
            }
        });
        
        Map<String, Integer> gemMap = new HashMap<>();
        int left = 0, right = 1, nowCount = 1;
        gemMap.put(gems[0], 1);
        while(left < right) {
            if (right < gems.length && nowCount < gemTypeCount) {
                int count = gemMap.getOrDefault(gems[right], 0);
                if (count == 0) {
                    nowCount++;
                }
                gemMap.put(gems[right], count+1);
                right++;
            } else {
                if (nowCount == gemTypeCount) {
                    pq.offer(new int[]{left+1, right});
                } 
                int count = gemMap.get(gems[left]);
                if (count == 1) {
                    nowCount--;
                }
                gemMap.put(gems[left], count-1);
                left++;
            }
        }
        
        return pq.poll();
    }
}
```
