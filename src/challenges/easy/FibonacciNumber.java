package challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FibonacciNumber {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String s = line.trim();
				int num = Integer.parseInt(s);
				System.out.println(getFibo(num));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
	public static int getFibo(int n){
		if(n <= 1) return n;
		
		int fibo = 1;
		int a = 0;
		int b = 1;
		for(int i=2; i<=n; i++){
			fibo = a + b;
			a = b;
			b = fibo;
		}
		
		return fibo;
	}
}