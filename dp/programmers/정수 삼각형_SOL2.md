## 정수 삼각형
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43105
* 시간 복잡도 : O(h x w)
```java
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        
        for(int i=h-2; i>=0; i--) {
            for(int j=0; j<triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}
```
