## 영어 끝말잇기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12981
* 시간 복잡도 : O(n)
```java
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        
        Set<String> st = new HashSet<>();
        st.add(words[0]);
        for (int i=1; i<words.length; i++) {
            String before = words[i-1];
            if (st.contains(words[i]) || before.charAt(before.length()-1) != words[i].charAt(0)) {
                answer[0] = (i%n)+1;
                answer[1] = (i+1)/n;
                if ((i+1) % n != 0) {
                    answer[1]++;
                }
                break;
            }
            st.add(words[i]);
        }
        
        return answer;
    }
}
```
