## 기지국 설치
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12979
* 시간 복잡도 : O(n)
```java
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int now = 1, stationIdx = 0; 
        while (now<=n) {
            if (stationIdx < stations.length) {
                int min = stations[stationIdx] - w;
                int max = stations[stationIdx] + w;
                if (min <= now && now <= max) {
                    now = max + 1;
                    stationIdx++;
                    continue;
                }
            } 
            //기지국 설치
            answer++;
            now += w*2+1; 
        }
        return answer;
    }
}
```
