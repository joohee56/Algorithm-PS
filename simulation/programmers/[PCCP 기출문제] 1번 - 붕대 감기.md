## [PCCP 기출문제] 1번 / 붕대 감기
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250137
* 시간 복잡도 : O(n)
```Java
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int remain = health, time=0;
        for(int[] attack : attacks) {
            remain = Math.min(health, remain + (attack[0]-time-1) * bandage[1]);
            int plus = (attack[0]-time-1)/bandage[0] * bandage[2];
            remain = Math.min(health, remain + plus);
            remain -= attack[1];
            if(remain <= 0) {
                remain = -1;
                break;
            }
            time = attack[0];
        }
        
        return remain;
    }
}
```
