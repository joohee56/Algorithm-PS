## JadenCase 문자열 만들기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12951#
* 시간 복잡도 : O(n)
```java
class Solution {
    public String solution(String s) {
        String answer = "";
        
        int st = 0;
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (st+1 <= i) {
                    answer += Character.toUpperCase(s.charAt(st)) + s.substring(st+1, i).toLowerCase();
                }
                answer += " ";
                st = i+1;
            }
        }
        if (st < s.length()) {
            answer += Character.toUpperCase(s.charAt(st)) + s.substring(st+1, s.length()).toLowerCase();
        }
        return answer;
    }
}
```
