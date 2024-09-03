## 프로세스
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42587
```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> que = new ArrayDeque<>();
        for (int i=0; i<priorities.length; i++) {
            que.offer(new int[]{i, priorities[i]});
        }
        
        int answer = 0;
        Arrays.sort(priorities);
        int idx = priorities.length-1;
        while(idx >= 0) {
            int now = priorities[idx];
            int[] priority = que.poll();
            if (priority[1] == now) {
                if (priority[0] == location) {
                    answer = priorities.length - idx;
                    break;
                }
                idx--;
            } else {
                que.offer(priority);
            }
        }
        return answer;
    }
}
```
