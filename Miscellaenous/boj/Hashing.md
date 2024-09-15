## 15829.Hashing
* 문제 링크 : https://www.acmicpc.net/problem/15829
* 시간 복잡도 : O(n)
```java
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		BigInteger r = new BigInteger("1");
		BigInteger answer = new BigInteger("0");
		for (int i=0; i<str.length(); i++) {
			answer = answer.add(BigInteger.valueOf(str.charAt(i)-'a'+1).multiply(r));
			r = r.multiply(BigInteger.valueOf(31));
		}
		int M = 1234567891;
		System.out.println(answer.remainder(BigInteger.valueOf(M)));
	}
}
```
