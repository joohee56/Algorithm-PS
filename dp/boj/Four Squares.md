## 17626. Four Squares
* 문제 링크 : https://www.acmicpc.net/problem/17626
* 시간 복잡도 : O(nxm)
* 풀이 참고 블로그 : https://steady-coding.tistory.com/18
```java
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int num = 2; num <= n; num++) {
			int min = Integer.MAX_VALUE;
			for (int j=1; j*j<=num; j++) {
				min = Math.min(min, dp[num-j*j]);
			}
			
			dp[num] = min+1;
		}
		System.out.println(dp[n]);
	}
}
```
