## 피보나치 수
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12945
* 시간 복잡도 : O(n)
```java
class Solution {
    public int solution(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}
```
