package challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumOfDigits {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String s = line.trim();
				int num = Integer.parseInt(s);
				int sum = 0;
				
				while (num != 0){
					sum = sum + (num % 10);
					num = num / 10;
				}
				
				System.out.println(sum);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
}
