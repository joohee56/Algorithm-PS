## [PCCP 기출문제] 2번 / 석유 시추
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250136
```Java
import java.util.*;

class Solution {
    int[][] land;
    int n, m;
    public int solution(int[][] land) {
        int answer = 0;
        this.land = land;
        this.n = land.length;
        this.m = land[0].length;
        
        Map<Integer, Integer> found = new HashMap<>();
        int no = 2;
        for(int j=0; j<m; j++) {
            int sum = 0;
            Set<Integer> nowLand = new HashSet<>();  //중복 제거 위해 set 사용
            for(int i=0; i<n; i++) {
                if(land[i][j] == 1) {  //탐색 안한 지역
                    int count = bfs(i, j, no);
                    found.put(no, count);
                    nowLand.add(no);
                    no++;
                } else if(land[i][j] > 1) {  //이미 탐색한 지역
                    nowLand.add(land[i][j]);
                }
            }
            
            for(Integer now : nowLand) {
                sum += found.get(now);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    int bfs(int x, int y, int no) {
        int count = 1;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        land[x][y] = no;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1}; 
        
        while(!que.isEmpty()) {
            int[] now = que.poll();
            
            for(int d=0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || land[nx][ny]!=1) continue;
                count++;
                que.add(new int[]{nx, ny});
                land[nx][ny] = no;
            }
        }
        
        return count;
    }
}
```
