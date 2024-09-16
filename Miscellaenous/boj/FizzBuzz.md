## 28702번. FizzBuzz
* 문제 링크 : https://www.acmicpc.net/problem/28702
* 시간 복잡도 : O(n)
```java
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = 0;
		for (int i=0; i<3; i++) {
			String str = br.readLine();
			if (number == 0 && Character.isDigit(str.charAt(0))) {
				number = Integer.parseInt(str) + 3 - i;
			}
		}
		
		String answer = "";
		if (number % 3 == 0) {
			answer += "Fizz";
		}
		if (number % 5 == 0) {
			answer += "Buzz";
		}
		
		System.out.println(answer != "" ? answer :  number);
	}
}
```
