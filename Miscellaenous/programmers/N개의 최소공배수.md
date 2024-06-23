## N개의 최소공배수
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12953?language=java
* 시간 복잡도 : O(n)
```Java
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    int gcd(int p, int q) {
        if (q==0) return p;
        return gcd(q, p % q);
    }
    
    int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }
}
```
