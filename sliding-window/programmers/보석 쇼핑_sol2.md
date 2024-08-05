## 보석 쇼핑
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67258

### SOL1
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
![image](https://github.com/user-attachments/assets/b8c629b2-e79b-4a18-ab54-b5c4f51930ed)

</br>

### SOL2
* 시간 복잡도 : O(n)
```java
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        int gemTypeCount = gemSet.size();
        
        Map<String, Integer> gemMap = new HashMap<>();
        int[] answer = new int[2];
        int left = 0, right = 1, minLength = Integer.MAX_VALUE;
        gemMap.put(gems[left], 1);
        while(left < right && right <= gems.length) {
            if (right < gems.length && gemMap.size() < gemTypeCount) {
                gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
                right++;
            } else {
                if (gemMap.size() == gemTypeCount) {
                    if (right - left < minLength) {
                        answer[0] = left + 1;
                        answer[1] = right;
                        minLength = right - left;
                    }
                } 
                int count = gemMap.get(gems[left]);
                if (count == 1) {
                    gemMap.remove(gems[left]);
                } else {
                    gemMap.put(gems[left], count-1);
                }
                left++;
            }
        }
        return answer;
    }
}
```
![image](https://github.com/user-attachments/assets/d280f1f5-3f25-4e71-96c1-49d42f73ac74)


