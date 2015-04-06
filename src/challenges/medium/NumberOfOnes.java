package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfOnes {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String s = line.trim();
				int num = Integer.parseInt(s);
				int sum = 0;
				
				while(num != 0){
					num = num & (num -1);
					sum += 1;
				}
				
				System.out.println(sum);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
}
