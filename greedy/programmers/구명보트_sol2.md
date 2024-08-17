## 구명보트
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42885
* 시간 복잡도 : O(nlogn)
```java
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length-1;
        while(left <= right) {
            answer++;
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                right--;
                left++;
            }
        }
        return answer;
    }
}
```
