## [PCCE 기출문제] 10번 / 데이터 분석
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250121
* 시간 복잡도 :  O(nlogn)
```Java
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        int extIndex = getIndex(ext);
        
        for(int[] item : data) {
            if(item[extIndex] < val_ext) {
                answer.add(item);
            }
        }
        
        int sortIndex = getIndex(sort_by);
        Collections.sort(answer, (o1, o2) -> (Integer.compare(o1[sortIndex], o2[sortIndex])));
        
        return answer.stream().toArray(int[][]::new);
    }
    
    int getIndex(String ext) {
        switch(ext) {
            case "code": 
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
        }
        return -1;
    }
}
```
