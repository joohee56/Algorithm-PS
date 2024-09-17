## 18110번. solved.ac
* 문제 링크 : https://www.acmicpc.net/problem/18110
* 시간 복잡도 : O(nlogn)
```java
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int removeCnt = (int) Math.round(n * 0.15);
		
		int[] scores = new int[n];
		for (int i=0; i<n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(scores);
		int sum = 0;
		for (int i=removeCnt, end = n-removeCnt; i<end; i++) {
			sum += scores[i];
		}
		n -= removeCnt * 2;
		System.out.println(Math.round((double)sum / n));
	}
}
```
