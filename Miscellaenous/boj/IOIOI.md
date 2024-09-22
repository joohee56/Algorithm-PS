## 5525. IOIOI
* 문제 링크 : https://www.acmicpc.net/source/84195486
* 시간 복잡도 : O(n)
```java
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int answer = 0;
		for (int i=2; i<m; i++) {
			if (s.charAt(i) == 'I' && s.charAt(i-1) == 'O' && s.charAt(i-2) == 'I') {
				int j = i+1;
				int zeroCnt = 1;
				
				while(j+1 < m) {
					if (s.charAt(j) == 'O' && s.charAt(j+1) == 'I') {
						zeroCnt++;
						j+=2;
					} else {
						break;
					}
				}
				
				if (zeroCnt >= n) {
					answer += zeroCnt - n +1;
				}
				
				i = j-1;
			}
		}
		
		System.out.println(answer);
	}
	
}
```
