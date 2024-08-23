## 이진 변환 반복하기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
```java
class Solution {
    public int[] solution(String s) {
        int totalZeroCnt = 0, changeCnt = 0;
        while(!s.equals("1")) {
            int oneCnt = 0;
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCnt++;
                }
            }
            
            totalZeroCnt += s.length() - oneCnt;
            changeCnt++;
            s = changeToBinary(oneCnt);
        }
        
        return new int[]{changeCnt, totalZeroCnt};
    }
    
    public String changeToBinary(int num) {
        String res = "";
        while(num > 0) {
            res = res + num % 2;
            num /= 2;
        }
        return res;
    }
}
```
