## JadenCase 문자열 만들기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=java#
* 시간 복잡도 : O(n)
```Java
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ");
        if(words.length==0) {
            return s;
        }
        
        for(String word : words) {
            if(word.equals("")) {
                answer.append(" ");
                continue;
            }
            
            if(!Character.isAlphabetic(word.charAt(0))) {
                answer.append(word.charAt(0));
            } else {
                answer.append(Character.toUpperCase(word.charAt(0)));
            }
            
            if(word.length() > 1) {
                answer.append(word.substring(1, word.length()).toLowerCase());
            }
            answer.append(" ");
        }
        if(answer.length() >= 1) {
            answer.deleteCharAt(answer.length()-1);
        }
        if(s.charAt(s.length()-1) == ' ') {
            answer.append(" ");
        }
        return answer.toString();
    }
}
```
