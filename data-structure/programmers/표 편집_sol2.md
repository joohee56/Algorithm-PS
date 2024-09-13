## 표 편집
* 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81303

### SOL1 (시간초과)
* 시간 복잡도 : O(mlogn)
```java
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        List<Integer> table = new ArrayList<>();
        for(int i=0; i<n; i++) {
            table.add(i);
        }
        
        Stack<Integer> removeSt = new Stack<>();
        for (String command : cmd) {
            int cnt = 0;
            switch(command.charAt(0)) {
                case 'U' :
                    cnt = Integer.parseInt(command.substring(2, command.length()));
                    k = (k-cnt+table.size()) % table.size();
                    break;
                case 'D':
                    cnt = Integer.parseInt(command.substring(2, command.length()));
                    k = (k+cnt) % table.size();
                    break;
                case 'C' :
                    removeSt.push(table.get(k));
                    table.remove(k);
                    if (k==table.size()) k--;
                    break;
                case 'Z' :
                    int target = removeSt.pop();
                    int idx = getIndex(table, target);
                    if (idx <= k) k++;
                    table.add(idx, target);
                    break;
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'X');
        for (int t : table) {
            answer[t] = 'O';
        }
        return String.valueOf(answer);
    }
    
    public int getIndex(List<Integer> table, int target) {
        if (target < table.get(0)) {
            return 0;
        }
        if (table.get(table.size()-1) < target) {
            return table.size();
        }
        
        int idx = -1;
        int start = 0, end = table.size()-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if (target < table.get(mid)) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
```
</br>

### SOL2 (해결)
* 시간 복잡도 : O(m)
```java
import java.util.*;

class Solution {
    class Node {
        int pre;
        int cur;
        int next;
        
        public Node(int pre, int cur, int next) {
            this.pre = pre;
            this.cur = cur;
            this.next = next; 
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        int[] pre = new int[n];
        int[] next = new int[n];
        for (int i=0; i<n; i++) {
            pre[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;  //마지막 노드의 다음 노드는 없음
        
        Stack<Node> removed = new Stack<>();
        for (String comm : cmd) {
            int cnt = 0;
            switch(comm.charAt(0)) {
                case 'U':
                    cnt = Integer.parseInt(comm.substring(2, comm.length()));
                    while(cnt-- > 0) {
                        k = pre[k];
                    }
                    break;
                case 'D':
                    cnt = Integer.parseInt(comm.substring(2, comm.length()));
                    while(cnt-- > 0) {
                        k = next[k];
                    }
                    break;
                case 'C':
                    removed.add(new Node(pre[k], k, next[k]));
                    answer[k] = 'X';
                    
                    //앞의 노드의 다음을 현재 노드의 다음으로 연결
                    if (pre[k] != -1) {
                        next[pre[k]] = next[k];
                    } 
                    //뒤의 노드의 앞을 현재 노드의 앞으로 연결
                    if (next[k] != -1) {
                        pre[next[k]] = pre[k];
                    }
                    
                    if (next[k] != -1) { //다음 노드가 있다면 
                        k = next[k];
                    } else {
                        k = pre[k];
                    }
                    break;
                case 'Z':
                    Node recent = removed.pop();
                    answer[recent.cur] = 'O';
                    
                    //앞의 노드의 다음을 현재 노드로 연결
                    if (recent.pre != -1) {
                        next[recent.pre] = recent.cur;
                    }
                    //뒤의 노드의 앞을 현재 노드로 연결
                    if (recent.next != -1) {
                        pre[recent.next] = recent.cur;
                    }
                    
                    break;
            }
        }
        
        return String.valueOf(answer);
    }
}
```
