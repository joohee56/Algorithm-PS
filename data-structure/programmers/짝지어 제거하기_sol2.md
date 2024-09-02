## 짝지어 제거하기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12973
* 시간 복잡도 : O(n)
```java
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if(!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        if(st.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
```
