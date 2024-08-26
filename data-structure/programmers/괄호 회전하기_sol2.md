## 괄호 회전하기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
* 시간 복잡도 : O(n<sup>2</sup>)
```java
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        while(n-- > 0) {
            s = s.substring(1, s.length()) + s.charAt(0);
            if(isCorrect(s)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isCorrect(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;
                char pair = st.pop();
                if ((ch == ']' && pair != '[') || (ch == ')' && pair != '(') || (ch == '}' && pair != '{')) return false;
            }
        }
        if (!st.isEmpty()) return false;
        return true;
    }
}
```
