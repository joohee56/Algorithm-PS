## 경주로 건설
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67259
```java
import java.util.*;

class Solution {
    
    public class Point {
        private int x;
        private int y;
        private int dir;
        private int cost;
        
        Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        } 
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(0, 0, -1, 0));
        boolean[][][] visited = new boolean[n][n][4];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!que.isEmpty()) {
            Point now = que.poll();
            
            if (board[now.x][now.y] >= answer) continue;
            if (now.x == n-1 && now.y == n-1) {
                answer = Math.min(answer, board[now.x][now.y]);
                continue;
            }
            
            for (int d=0; d<4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;
                
                int plusCost = (now.dir == -1 || now.dir == d) ? 100 : 600;
                int nextCost = now.cost + plusCost;
                if (!visited[nx][ny][d] || nextCost <= board[nx][ny]) {
                    visited[nx][ny][d] = true;
                    board[nx][ny] = nextCost;
                    que.offer(new Point(nx, ny, d, nextCost));
                }
            }
        }
        return answer;
    }
    
}
```
