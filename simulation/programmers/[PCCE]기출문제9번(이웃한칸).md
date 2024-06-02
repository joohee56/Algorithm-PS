## [PCCE]기출문9번/이웃한 칸
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250125
* 시간 복잡도 : O(n)
```Java
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int d=0; d<4; d++) {
            int nx = h+dx[d];
            int ny = w+dy[d];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(board[nx][ny].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}
```
