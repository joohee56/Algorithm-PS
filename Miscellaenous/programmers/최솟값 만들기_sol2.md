## 최솟값 만들기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12941
* 시간 복잡도 : O(nlogn)
```java
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i=0; i<A.length; i++) {
            answer += A[i] * B[A.length-i-1];
        }
        return answer;
    }
}
```
